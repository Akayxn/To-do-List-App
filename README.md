# TaskMaster

A feature-rich desktop todolist application built with JavaFX, focusing on security, clean architecture, and user experience.

## 📌 Features

- **User Authentication System**
  - Secure signup and login functionality
  - Argon2 password hashing for maximum security

- **Secure Data Management**
  - SQLite relational database with proper normalization
  - Secret key management with zero-knowledge principles
  - Secure data handling with proper resource zeroing

- **Clean Architecture**
  - Dependency Injection for loosely coupled components
  - SOLID principles implementation
  - DRY (Don't Repeat Yourself) approach throughout codebase
  - CASE (Computer-Aided Software Engineering) methodology

- **Intuitive User Interface**
  - Responsive JavaFX design
  - Event-driven programming for smooth user interactions
  - Modern UI components and animations

## 🛠️ Technology Stack

- **Frontend**: JavaFX
- **Database**: SQLite
- **Security**: Argon2 password hashing, secure key management
- **Architecture**: Dependency Injection, SOLID, DRY principles

## 🔒 Security Implementation

- **Password Security**: Argon2 hashing algorithm with salting
- **Secret Management**: Proper handling of application secrets
- **Zero Knowledge Principles**: Critical information zeroed after use
- **Input Validation**: Comprehensive validation to prevent injection attacks

## 🚀 Getting Started

### Prerequisites
- Java 11 or newer
- Maven (for dependency management)

### Installation

1. Clone the repository
   ```
   git clone https://github.com/yourusername/taskmaster.git
   ```

2. Navigate to the project directory
   ```
   cd taskmaster
   ```

3. Build the project
   ```
   mvn clean install
   ```

4. Run the application
   ```
   java -jar target/taskmaster.jar
   ```

## 🏗️ Architecture Overview

The application follows a layered architecture:

- **Presentation Layer**: JavaFX views and controllers
- **Service Layer**: Business logic and application services
- **Repository Layer**: Data access and persistence
- **Domain Layer**: Core business entities and logic

Dependency injection is used throughout to ensure loose coupling between components, making the code more testable and maintainable.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## 🙏 Acknowledgements

- [JavaFX](https://openjfx.io/) for the UI framework
- [SQLite](https://www.sqlite.org/) for the embedded database
- [Argon2](https://github.com/P-H-C/phc-winner-argon2) for secure password hashing
