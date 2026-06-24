# EnsetStock Console - Angular + Spring Boot

Application de gestion de produits avec un frontend Angular 19 (standalone) et un backend Spring Boot (H2 en memoire).

## Ce que ça fait

- Page Catalogue (route principale)
- Liste des produits dans un tableau
- Formulaire CRUD pour ajouter et modifier un produit
- Une colonne "Selected" pour activer/desactiver l'etat
- Un bouton Delete (avec icone et confirmation avant suppression)

## Screens

**Ajout + affichage**

![Ajout et affichage](./screens/ajout%20+%20display.png)

**Suppression + affichage**

![Suppression et affichage](./screens/delete+%20display.png)

**Mise a jour + affichage**

![Mise a jour et affichage](./screens/update%20+%20display.png)

## Comment lancer

**Backend** (port 8080) :
```
cd backend
mvn clean package -DskipTests
java -jar target/productapp-1.0.0.jar
```

**Frontend** (port 4200) :
```
cd frontend
npm install
npx ng serve
```

Puis ouvrir http://localhost:4200

## API (pour tester avec Postman)

| Méthode | URL | Description |
|---|---|---|
| GET | `http://localhost:8080/products` | Liste tous les produits |
| GET | `http://localhost:8080/products/{id}` | Retourne un produit |
| POST | `http://localhost:8080/products` | Cree un produit |
| PUT | `http://localhost:8080/products/{id}` | Met a jour un produit |
| DELETE | `http://localhost:8080/products/{id}` | Supprime un produit |
| PUT | `http://localhost:8080/products/{id}/selected?value=true` | Change l'etat "selected" (`true` ou `false`) |

## Stack

- Angular 19 (standalone components, pas de modules)
- Bootstrap 5 + Bootstrap Icons
- Spring Boot 3.3 + Spring Data JPA
- Base H2 en mémoire (les données sont remises à zéro à chaque redémarrage du backend, via `data.sql`)

## Structure

```
backend/
  src/main/java/com/youssfi/productapp/
    model/        -> entité Product (JPA)
    repository/   -> ProductRepository
    controller/   -> ProductRestController (CRUD + PUT /selected)

frontend/
  src/app/
    models/       -> interface InventoryItem
    services/     -> InventoryApiService (appels HTTP)
    pages/inventory/ -> page catalogue
```

## Notes

- CORS est ouvert pour `http://localhost:4200` côté backend.
- La console H2 est accessible sur http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:productdb`, user `sa`, sans mot de passe).
