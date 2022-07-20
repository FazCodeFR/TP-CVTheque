# CVTheque


## Info complémentaire

TP : CVThèque en Kotlin (CDAN IPI 2022)

Sur le cours IPRM200 - Débuter avec Kotlin - Débuter avec Kotlin

Par l'intervenant Anthony M.

Temps passé sur le projet : 5 heures

Léo & Florian A. - IPI CDAN 2022


## Le but du projet 

Lister des CV de candidat, afin de centraliser les données et d’uniformisé les CV reçu.
Possibilité d’ajouter un candidat avec tous les informations nécessaires à son CV.
 
Utilisé le projet : 
Télécharger l’archive du projet, dézipper le projet à un lieux adapté, ouvrir avec Inteliji IDEA, puis 

Dans src/main/resources/application.properties vérifier les informations de connexion.

## Lancer le projet 

Lancer votre SGBD, et importer le fichier CVTheque.sql afin de créer la bdd
Puis dans Inteliji IDEA, Build le projet et enfin lancer l'application

## Ressource 
Le fichier Projet Kotlin Candidat.postman_collection.json
Contient une collection json des requêtes si besoin

## Visuel des pages HTML : 

### Page d’accueil : (http://localhost:8083/)

![image](https://user-images.githubusercontent.com/30906528/179932834-5d7012fa-1d27-47f5-8c24-105a5384baad.png)



### Page d’un candidat : (http://localhost:8083/candidat/1)
![image](https://user-images.githubusercontent.com/30906528/179933032-f225b8d4-d819-447c-8f9c-794e726265fe.png)


### Page de login : (http://localhost:8083/login) 
![image](https://user-images.githubusercontent.com/30906528/179933075-adae1775-a4d4-44c2-a692-41f0feb7a7dc.png)
Note : <em>Non mis en place.</em>


## Structure de la base de données

![image](https://user-images.githubusercontent.com/30906528/179934055-62621537-85e9-4bfe-ba15-5dff046061a4.png)




## Les requêtes : 


### Lister tous les candidats : 

```
URL : http://localhost:8083/api/all
Type de requête: GET
Sortie: JSON
```



### Avoir toutes les informations reliées à un candidat :

```
URL : http://localhost:8083/api/getCandidat/1
Type de requête: GET
Parametre : id du candidat
```

#### Sortie (JSON) :

``` json 
{
    "id": 1,
    "nom": "Dupied",
    "prenom": "Leo",
    "date_naiss": "20/05/2000",
    "adresse": "3 Rue du tort, 31000 Toulouse",
    "email": "leo@gmail.com",
    "telephone": "0671230505",
    "cv_experiences": [
        {
            "id": 1,
            "id_candidat": 1,
            "titre": "Développeur front",
            "date_debut": "Janvier 2020",
            "date_fin": "Décembre 2021",
            "description": "Développement d'une interface de visualisation pour un satellite",
            "entreprise": " IT CORPORATE",
            "ville": "Toulouse",
            "type_contrat": "CDD"
        },
        {
            "id": 2,
            "id_candidat": 1,
            "titre": "Développeur  fullstack",
            "date_debut": "Février 2021",
            "date_fin": "Février 2022",
            "description": "Développement d'un site web ecommerce",
            "entreprise": "SOFTWARE&CO",
            "ville": "Paris",
            "type_contrat": "CDI"
        }
    ],
    "cv_formation": [
        {
            "id": 1,
            "id_candidat": 1,
            "titre": "BTS SIO option SLAM",
            "date_debut": "Septembre 2017",
            "date_fin": "Juillet 2019",
            "ecole": "IPI",
            "ville": "Toulouse"
        },
        {
            "id": 2,
            "id_candidat": 1,
            "titre": "Baccaloréat scientifique",
            "date_debut": "Septembre 2014",
            "date_fin": "Juillet 2017",
            "ecole": "Lycée Lavoisier",
            "ville": "Lyon"
        }
    ],
    "cv_competence_principale": [
        {
            "id": 1,
            "id_candidat": 1,
            "titre": "HTML"
        },
        {
            "id": 2,
            "id_candidat": 1,
            "titre": "CSS"
        },
        {
            "id": 3,
            "id_candidat": 1,
            "titre": "JS"
        },
        {
            "id": 4,
            "id_candidat": 1,
            "titre": "PHP"
        }
    ],
    "cv_competence_secondaire": [
        {
            "id": 1,
            "id_candidat": 1,
            "titre": "Word"
        },
        {
            "id": 2,
            "id_candidat": 1,
            "titre": "Excel"
        },
        {
            "id": 3,
            "id_candidat": 1,
            "titre": "Powerpoint"
        }
    ]
}
```


### Ajouter un candidat

```
URL : http://localhost:8083/api/addCandidat
Type de requête: POST
Sortie: JSON
Entrée (JSON) = 
{
    "nom": "Yess",
    "prenom": "Paullll",
    "date_naiss": "05/01/2000",
    "adresse": "Rue du Superprof",
    "email": "leo@gmail.com",
    "telephone": "0671230605"
}
```





### Ajouter une expérience à un candidat
```
URL: http://localhost:8083/api/addExperience/2
Parametre : id du candidat
Type de requête: POST 
Sortie: JSON 
Entrée (JSON) = 
{
    "titre": "Alternance dev web",
    "date_debut": "01/02/2022",
    "date_fin": "01/06/2022",
    "description": "Création site front",
    "entreprise": "CGI",
    "ville": "Toulouse",
    "type_contrat": "Alternance"
}
```


### Ajouter une formation à un candidat
```
POST http://localhost:8083/api/addFormation/2
Parametre : id du candidat
Type de requête: POST
Entrer: 
Sortie: JSON 

ENTRER (JSON) =
{
    "titre": "Developpeur Web et Mobile",
    "date_debut": "01/02/2022",
    "date_fin": "01/03/2022",
    "ecole": "IPI",
    "ville": "Toulouse"
}
```









