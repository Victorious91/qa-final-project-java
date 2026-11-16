# qa-final-project-java

# QA Final Project - Java

[![Java CI/CD Pipeline](https://github.com/Victorious91/qa-final-project-java/actions/workflows/ci.yaml/badge.svg)](https://github.com/Victorious91/qa-final-project-java/actions/workflows/ci.yaml)


Acest proiect reprezintă examenul final de absolvire (zborul solo) în cadrul școlii de testare și DevOps. 
Proiectul configurează o structură standard de aplicație Java/Maven, include planificarea unui test API și implementează un pipeline automatizat de integrare continuă 
CI/CD) folosind GitHub Actions și Docker.

---

## 🚀 Ce face proiectul

Proiectul integrează bunele practici de DevOps și QA:
* **Configurare flexibilă:** Managementul mediilor prin fișiere YAML (`config/app.yaml`).
* **Planificare QA:** Design de teste API în pseudocod (`ApiTest.txt`) pregătite pentru automatizare viitoare.
* **Containerizare:** Împachetarea securizată și optimizată a aplicației Java cu Docker folosind o strategie de Multi-stage Build.
* **Automatizare (CI/CD):** Executarea automată a testelor și publicarea imaginii pe Docker Hub la fiecare schimbare adusă codului din branch-ul principal.

---

## 🧪 Cum se rulează testele local

Testul API este documentat în pseudocod (`ApiTest.txt`). Testele de UI sunt automatizate cu **BDD**
(Cucumber + JUnit 4 + Selenide) pe aplicatia demo `https://www.saucedemo.com`
(site public creat pentru exersarea automatizarii, fara captcha).

1. Asigură-te că ai Java 17 și Maven instalate pe mașina locală (plus Firefox sau Chrome).
2. Deschide terminalul în rădăcina proiectului și execută:
   ```bash
   mvn clean test
   ```
3. Parametri opționali (în PowerShell se pun între ghilimele): `"-Dbrowser=chrome"`, `"-Dheadless=true"`,
   `"-DbaseUrl=..."`, `"-Dsaucedemo.user=..."`, `"-Dsaucedemo.password=..."`.
   Implicit se folosește `standard_user` / `secret_sauce` (credențiale publice afișate pe pagina de login).
4. Raportul HTML se generează în `target/cucumber-reports/report.html`.

### Structura testelor BDD (`src/test`)
* `resources/features` – fișierele Gherkin: `Login`, `Cart`, `Product`, `Checkout`
  (include `Scenario Outline` și `Data Table`).
* `java/com/Victorious91/tests/pages` – Page Object Model (toți locatorii sunt aici).
* `java/com/Victorious91/tests/stepdefinitions` – pașii Cucumber și `Hooks` (setup/teardown).
* `java/com/Victorious91/tests/runners` – `TestRunner` (JUnit 4) cu raport HTML.
* `java/com/Victorious91/tests/config` – `TestConfig` (URL, browser, credențiale).

---

## 🐳 Cum se folosește Docker

Proiectul include un fișier `Dockerfile` care automatizează descărcarea dependențelor, compilarea codului și rularea aplicației într-un mediu izolat.

### 1. Construirea imaginii Docker
Pentru a genera imaginea Docker local, rulează următoarea comandă în terminal:
```bash
docker build -t qa-final-project-java .
```

### 2. Rularea containerului
După ce construirea s-a finalizat cu succes, poți porni containerul mapând portul intern al aplicației:
```bash
docker run -p 8080:8080 qa-final-project-java
```

---

## 🛠️ Pipeline-ul CI/CD

La fiecare `push` pe branch-ul `main`, GitHub Actions va lansa automat fluxul de lucru definit în `.github/workflows/ci.yaml`:
1. **Job-ul de Testare:** Rulează `mvn test` (teste BDD headless) pe o mașină virtuală Linux și publică raportul Cucumber ca artefact.
2. **Job-ul de Docker:** Dacă testele trec cu succes, se autentifică pe Docker Hub, construiește imaginea finală și o publică cu tag-urile `latest` și ID-ul unic al commit-ului (`SHA`).
