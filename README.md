<!-- Language: [🇺🇸 English](#en) | [🇧🇷 Português](#pt-br) -->

<p align="center">
  <a href="#en">🇺🇸 English</a> | <a href="#pt-br">🇧🇷 Português</a>
</p>

---

## 🇺🇸 English <a id="en"></a>

# 🔗 LinkShortener

Welcome to **LinkShortener**!  
This project is an application for shortening URLs quickly, securely, and efficiently. With LinkShortener, you can turn long URLs into short, easy-to-share links, monitor link access, and manage your custom links.

---

### 🚀 Technologies & Tools Used

- **Backend:** [NestJS](https://nestjs.com/) (TypeScript)
- **Frontend:** [Kotlin](https://kotlinlang.org/) with Jetpack Compose (Android)

---

### 🏗️ Project Architecture

The solution is divided into two main layers:

- **Backend (NestJS):**
  - Handles link shortening, redirections, and data management.
  - Exposes RESTful APIs for the frontend to interact with.
- **Frontend (Kotlin + Jetpack Compose):**
  - Mobile application providing a user-friendly interface for creating and managing short links.
  - Consumes the backend APIs for all operations.

The architecture follows the separation of concerns principle, making the project easy to maintain and scale.

---

### ⚙️ How to Run Locally

1. **Clone the repository:**
   ```bash
   git clone https://github.com/IagoAntunes/LinkShortener.git
   cd LinkShortener
   ```

2. **Backend (NestJS):**
   - Navigate to the backend folder (if applicable):
     ```bash
     cd backend
     ```
   - Install dependencies and run the server:
     ```bash
     npm install
     npm run start:dev
     ```
   - The API will be available at [http://localhost:3000](http://localhost:3000)

3. **Frontend (Kotlin + Jetpack Compose):**
   - Open the `frontend` folder in [Android Studio](https://developer.android.com/studio).
   - Build and run the application on an emulator or Android device.
   - Make sure the app points to your local backend (configure base URL if needed).

---

## 🇧🇷 Português <a id="pt-br"></a>

# 🔗 LinkShortener

Bem-vindo ao **LinkShortener**!  
Este projeto é uma aplicação para encurtar URLs de forma rápida, segura e eficiente. Com ele, você pode transformar links longos em URLs curtas e fáceis de compartilhar, monitorar acessos e gerenciar seus links personalizados.

---

### 🚀 Tecnologias & Ferramentas Utilizadas

- **Backend:** [NestJS](https://nestjs.com/) (TypeScript)
- **Frontend:** [Kotlin](https://kotlinlang.org/) com Jetpack Compose (Android)

---

### 🏗️ Arquitetura do Projeto

A solução é dividida em duas camadas principais:

- **Backend (NestJS):**
  - Responsável pelo encurtamento de links, redirecionamentos e gerenciamento de dados.
  - Expõe APIs RESTful para comunicação com o app.
- **Frontend (Kotlin + Jetpack Compose):**
  - Aplicativo mobile com interface amigável para criar e gerenciar links.
  - Consome as APIs do backend para realizar as operações.

A arquitetura segue o princípio de separação de responsabilidades, facilitando a manutenção e escalabilidade do projeto.

---

### ⚙️ Como Rodar Localmente

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/IagoAntunes/LinkShortener.git
   cd LinkShortener
   ```

2. **Backend (NestJS):**
   - Navegue até a pasta do backend (se aplicável):
     ```bash
     cd backend
     ```
   - Instale as dependências e rode o servidor:
     ```bash
     npm install
     npm run start:dev
     ```
   - A API estará disponível em [http://localhost:3000](http://localhost:3000)

3. **Frontend (Kotlin + Jetpack Compose):**
   - Abra a pasta `frontend` no [Android Studio](https://developer.android.com/studio).
   - Compile e execute o aplicativo em um emulador ou dispositivo Android.
   - Certifique-se de que o app está configurado para apontar para o backend local (ajuste a base URL se necessário).

---

<p align="center">
  <a href="#en">🇺🇸 English</a> | <a href="#pt-br">🇧🇷 Português</a>
</p>
