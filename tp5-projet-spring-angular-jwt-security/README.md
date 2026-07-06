# Bank Account Management Platform with AI Agent

Application web de gestion de comptes bancaires construite avec Spring Boot, Angular, Spring Security, JWT et un chatbot AI base sur RAG.

Le projet a pour objectif de proposer une solution complete pour la gestion des clients, des comptes, des operations bancaires, du tableau de bord, ainsi qu'un assistant conversationnel capable d'aider l'utilisateur dans ses taches metier.

## Presentation du projet

Reference video de presentation :

- https://www.youtube.com/watch?v=x6gFWmRxNPE&authuser=0

## Objectifs fonctionnels

- Gerer des clients bancaires.
- Gerer plusieurs comptes par client.
- Supporter deux types de comptes :
  - Comptes courants
  - Comptes epargnes
- Gerer les operations bancaires de type DEBIT et CREDIT.
- Fournir une interface web moderne avec Angular.
- Proteger l'application avec Spring Security et JWT.
- Ajouter un chatbot AI base sur RAG.
- Integrer le chatbot dans l'application de gestion bancaire.
- Fournir un dashboard avec graphiques et statistiques.

## Architecture cible

L'application est decoupee en 4 grandes parties :

1. Backend Spring Boot
2. Client Angular
3. Couche de securite JWT
4. Service chatbot AI avec RAG et client Telegram

## Partie 1 - Backend Spring Boot

### Etapes de realisation

1. Creer un projet Spring Boot.
2. Creer les entites JPA :
   - Customer
   - BankAccount
   - SavingAccount
   - CurrentAccount
   - AccountOperation
3. Creer les repositories Spring Data JPA.
4. Tester la couche DAO.
5. Implementer la couche service et les DTOs.
6. Exposer les REST controllers.
7. Tester les web services RESTful.

### API documentation avec Swagger

Pour Spring Boot 3, utiliser la dependance suivante :

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.1.0</version>
</dependency>
```

### Entites metier attendues

- Un client peut posseder plusieurs comptes.
- Un compte appartient a un seul client.
- Un compte peut avoir plusieurs operations.
- Une operation enregistre un montant, une date, un type et une reference metier.
- Les comptes peuvent etre specialises selon le type de gestion souhaite.

### Tests backend

- Tests des repositories.
- Tests des services.
- Tests des controllers REST.
- Tests d'integration des endpoints principaux.

### Ressources video backend

- https://www.youtube.com/watch?v=muuFQWnCQd0&authuser=0
- https://www.youtube.com/watch?v=PTI8cniOXLc

## Partie 2 - Client Angular

Le client Angular permet de consommer les API backend et de fournir une interface ergonomique pour :

- la gestion des clients,
- la gestion des comptes,
- la saisie des operations,
- la consultation des historiques,
- l'administration des utilisateurs,
- le dashboard de pilotage.

### Ressource video Angular

- https://www.youtube.com/watch?v=bOoPKctcE0s

## Partie 3 - Securite Spring Security + JWT

Cette partie a pour but de securiser l'ensemble de l'application avec :

- authentification des utilisateurs,
- generation et validation de JSON Web Token,
- protection des endpoints REST,
- gestion des roles et des autorisations,
- changement de mot de passe,
- traçabilite des actions par utilisateur authentifie.

### Exigence de traçabilite

Pour chaque client, compte et operation enregistree, il faut persister l'identifiant de l'utilisateur authentifie qui a realise l'action.

### Ressource video securite

- https://www.youtube.com/watch?v=n65zFfl9dqA

## Partie 4 - Chatbot AI avec RAG

Le projet integre un chatbot AI base sur RAG (Retrieval Augmented Generation) afin d'assister l'utilisateur dans la recherche d'informations et les taches de gestion.

### Objectifs du chatbot

- Repondre aux questions sur les comptes et les clients.
- Aider a naviguer dans l'application.
- Fournir des explications sur les operations metier.
- Se connecter a des sources de connaissances internes via RAG.
- Proposer une interface Telegram pour l'usage conversationnel.

### Ressources video chatbot

- https://www.youtube.com/watch?v=Q12plqwksxk
- https://www.youtube.com/watch?v=iIdmOcZcapM

## Partie 5 - Integration du chatbot dans l'application

Le chatbot AI doit etre integre a l'application de gestion bancaire afin de :

- faciliter l'acces aux informations metier,
- automatiser certaines reponses frequentes,
- offrir une experience utilisateur unifiee,
- relier les donnees bancaires, la recherche documentaire et l'assistance conversationnelle.

## Fonctionnalites supplementaires souhaitees

- Gestion des clients : ajout, edition, suppression, recherche, consultation.
- Gestion des comptes : creation, recherche, administration, consultation.
- Gestion des utilisateurs : comptes, mots de passe, changement de mot de passe.
- Gestion des autorisations selon les roles.
- Tableau de bord avec ChartJS / ng-chart.
- Statistiques utiles a la prise de decision.
- Historique des operations et des actions utilisateur.
- Ameliorations metier additionnelles selon les besoins du projet.

## Configuration de la cle OpenAI

La cle OpenAI ne doit jamais etre committee dans GitHub.

Utiliser une variable d'environnement locale, par exemple :

```bash
OPENAI_API_KEY=your_openai_api_key
```

Ou, selon la configuration Spring Boot :

```bash
export OPENAI_API_KEY=your_openai_api_key
```

Recommandations :

- ne jamais hardcoder la cle dans le code,
- ne jamais la stocker dans un fichier versionne,
- utiliser un fichier local ignore par Git pour les variables sensibles.

## Technologies prevues

### Backend

- Java 17+
- Spring Boot 3
- Spring Data JPA
- Spring Security
- JWT
- Swagger / OpenAPI
- JUnit
- Mockito
- H2 ou MySQL selon l'environnement

### Frontend

- Angular
- TypeScript
- RxJS
- ChartJS / ng-chart
- Angular forms
- HTTP Client

### AI / Chatbot

- RAG
- OpenAI API
- Telegram Bot API
- Vector store ou moteur de recherche documentaire selon le choix d'implementation

## Livrables attendus

- Backend fonctionnel et teste.
- Frontend Angular fonctionnel.
- Authentification securisee par JWT.
- Chatbot AI integre.
- Dashboard avec statistiques.
- Documentation technique et fonctionnelle.

## Demarrage du projet

Ce depot contient la specification et la base documentaire du projet. Les modules backend, frontend et AI peuvent ensuite etre ajoutes progressivement selon l'architecture choisie.

## Remarques

- Le projet doit respecter les bonnes pratiques de securite.
- Les operations sensibles doivent etre journalisees.
- Les donnees metier doivent rester coherentes entre les differentes couches.
- Les tests automatises doivent accompagner chaque couche importante.
