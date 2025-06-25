
# Quiz Web Application - Spring Boot

This is a full-stack Java-based Quiz Web Application built using Spring Boot for backend services, HTML/CSS/JS for the frontend, and MySQL as the database.

---

## 🚀 Tech Stack

- **Backend:** Spring Boot, Java
- **Frontend:** HTML, CSS, JavaScript
- **Database:** MySQL (local or cloud-hosted)
- **Build Tool:** Maven
- **Containerization:** Docker

---

## 📁 Project Structure

```
src
└── main
    ├── java
    │   └── com.project.QuizWebApplication
    │       ├── Controller
    │       │   └── QuizController.java
    │       ├── Model
    │       │   ├── Contest.java
    │       │   ├── QuestionWrapper.java
    │       │   ├── QuizQuestion.java
    │       │   └── Response.java
    │       ├── Repository
    │       │   ├── ContestRepo.java
    │       │   └── QuestionsRepo.java
    │       ├── Services
    │       │   ├── ContestService.java
    │       │   └── QuizServices.java
    │       └── QuizWebApplication.java
    ├── resources
    │   ├── static
    │   │   ├── index.html
    │   │   ├── about.html
    │   │   ├── contact.html
    │   │   ├── createQuiz.html
    │   │   ├── HomePage.html
    │   │   ├── quiz.html
    │   │   ├── result.html
    │   │   ├── thank-you.html
    │   │   ├── script.js
    │   │   └── style.css
    │   ├── templates
    │   └── application.properties
```

---

## 🐬 MySQL Configuration

In `application.properties`, configure your local DB:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quiz
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

> 🔔 Make sure your local MySQL server is running and the database `quiz` exists.

---

## 🐙 Clone the Repository

```bash
git clone https://github.com/KalaiSelvam31/Quiz_Web_Application-Spring-Boot.git
cd Quiz_Web_Application-Spring-Boot
```

---

## 🐳 Docker Setup

Build and run the app using Docker:

1. Build:
   ```bash
   docker build -t quiz-app .
   ```

2. Run:
   ```bash
   docker run -p 8080:8080 quiz-app
   ```

---

## 📦 Build with Maven

```bash
mvn clean install
```

Run the app:

```bash
mvn spring-boot:run
```

---

## 🌐 Access Frontend

Once running, access the frontend pages via:

```
http://localhost:8080/index.html
http://localhost:8080/quiz.html
```

> All HTML/JS/CSS files are inside the `static` folder, accessible directly via browser.

---

## 🤝 Contributing

Pull requests are welcome. For major changes, open an issue first to discuss.

---

## 📄 License

[MIT License](LICENSE)
