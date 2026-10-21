# FitnessClubXML — XML, XSD & XPath with Java

## 1. Présentation du projet

Ce projet a été réalisé dans le cadre d'un TP visant à manipuler des documents XML en Java.

L'objectif est de modéliser les données d'une salle de sport, de valider leur structure à l'aide d'un schéma XSD et d'extraire des informations spécifiques grâce aux requêtes XPath.

## 2. Objectifs pédagogiques

- Modéliser des données avec XML.
- Définir la structure d'un document XML avec XSD.
- Créer et organiser un projet Java avec Maven.
- Valider un document XML à l'aide de `SchemaFactory` et `Validator`.
- Interroger un document XML avec XPath.

## 3. Technologies utilisées

- Java JDK 8 ou supérieur
- Maven
- XML
- XML Schema Definition (XSD)
- XPath
- IntelliJ IDEA

## 4. Structure du projet

```text
FitnessClubXML/
├── pom.xml
├── README.md
├── .gitignore
└── src/
    └── main/
        ├── java/
        │   └── Main.java
        └── resources/
            ├── fitness.xml
            └── fitness.xsd
```

## 5. Description des fichiers

- **`pom.xml`** : configuration du projet Maven.
- **`fitness.xml`** : contient les informations des membres de la salle de sport.
- **`fitness.xsd`** : définit la structure et les types de données autorisés.
- **`Main.java`** : réalise la validation XML/XSD et les recherches XPath.
- **`.gitignore`** : exclut les fichiers générés et les paramètres locaux inutiles.

## 6. Fonctionnalités

### Validation XML/XSD

Le programme vérifie que le document `fitness.xml` respecte les règles définies dans `fitness.xsd`.

La validation permet notamment de détecter des valeurs incorrectes, comme un âge textuel alors qu'un entier positif est attendu.

### Interrogation XPath

Le programme effectue des recherches dans le document XML.

Exemples de requêtes :

**Afficher les noms des membres actifs :**

```xpath
/fitnessClub/membres/membre[actif='true']/nom
```

**Afficher les noms des membres Premium :**

```xpath
/fitnessClub/membres/membre[abonnement='Premium']/nom
```

## 7. Installation et exécution

1. Cloner ou télécharger le repository GitHub.
2. Ouvrir le projet dans IntelliJ IDEA.
3. Vérifier que le JDK est correctement configuré.
4. Charger le projet Maven.
5. Ouvrir `Main.java`.
6. Exécuter la méthode `main()`.

## 8. Résultats attendus

Si le document XML est valide, le programme affiche un message de validation positive, puis les noms des membres actifs et des membres Premium.

Avec les données d'exemple fournies, les deux recherches retournent Ahmed et Amine.

## 9. Conclusion

Ce projet met en pratique l'utilisation de XML pour représenter des données, de XSD pour en vérifier la structure et de XPath pour effectuer des recherches. Java permet de combiner ces fonctionnalités dans une application simple et organisée.

## Auteur

Réalisé dans le cadre d'un TP de programmation Java, XML, XSD et XPath.
