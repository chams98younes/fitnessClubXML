import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

    public static void main(String[] args) {
        String xmlPath = "src/main/resources/fitness.xml";
        String xsdPath = "src/main/resources/fitness.xsd";

        try {
            // 1. Validation XML / XSD
            SchemaFactory schemaFactory =
                    SchemaFactory.newInstance(
                            XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema =
                    schemaFactory.newSchema(new File(xsdPath));

            schema.newValidator().validate(
                    new javax.xml.transform.stream.StreamSource(
                            new File(xmlPath)));

            System.out.println("XML valide selon le schema XSD.");

            // 2. Charger le document XML
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlPath));

            // 3. Créer XPath
            XPath xpath = XPathFactory.newInstance().newXPath();

            // Requete 1 : membres actifs
            String expression1 = "/fitnessClub/membres/membre[actif='true']/nom";

            NodeList actifs = (NodeList) xpath.evaluate(
                    expression1, document, XPathConstants.NODESET);

            System.out.println("\nMembres actifs :");

            for (int i = 0; i < actifs.getLength(); i++) {
                System.out.println("- " + actifs.item(i).getTextContent());
            }

            // Requete 2 : membres Premium
            String expression2 =
                    "/fitnessClub/membres/membre[abonnement='Premium']/nom";

            NodeList premium = (NodeList) xpath.evaluate(
                    expression2, document, XPathConstants.NODESET);

            System.out.println("\nMembres Premium :");

            for (int i = 0; i < premium.getLength(); i++) {
                System.out.println("- " + premium.item(i).getTextContent());
            }

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
