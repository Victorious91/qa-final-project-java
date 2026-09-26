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

Deoarece logica testului API este momentan documentată în pseudocod, comanda nativă Maven va rula un set de teste gol, dar valid:

1. Asigură-te că ai Java 17 și Maven instalate pe mașina locală.
2. Deschide terminalul în rădăcina proiectului și execută:
   ```bash
   mvn test
   ```
3. Testul va returna un rezultat de tip `SUCCESS` deoarece structura este validă și nu există erori de compilare.

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

La fiecare `push` pe branch-ul `main`, GitHub Actions va lansa automat fluxul de lucru definit în `.github/workflows/ci.yml`:
1. **Job-ul de Testare:** Rulează `mvn test` pe o mașină virtuală Linux.
2. **Job-ul de Docker:** Dacă testele trec cu succes, se autentifică pe Docker Hub, construiește imaginea finală și o publică cu tag-urile `latest` și ID-ul unic al commit-ului (`SHA`).
