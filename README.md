# 📊 API REST - Calculadora de IRPF com Dashboard Analítico

<p align="left">
  <img src="https://img.shields.io/badge/Status-Em%20Produção-success?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white"/>
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white"/>
  <img src="https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens"/>
</p>

> **Deploy na Nuvem (Render):** https://calculadora-irpf.onrender.com

---

## 💡 Sobre o Projeto

Esta é uma **API RESTful** desenvolvida para automatizar o cálculo das faixas de Imposto de Renda Pessoa Física (IRPF), traduzindo regras de negócio financeiras complexas em um serviço seguro, rápido e exato. 

O objetivo principal do projeto é processar rendimentos e deduções, aplicando a progressividade das alíquotas fiscais e retornando um resumo analítico pronto para ser consumido por aplicações web ou dashboards financeiras.

### 🎯 Principais Desafios e Soluções
* **Exatidão Financeira:** Utilização rigorosa da classe `BigDecimal` do Java para evitar erros de arredondamento comuns em pontos flutuantes (`double`/`float`), garantindo precisão absoluta nos cálculos de centavos.
* **Segurança de Dados:** Implementação de camadas de segurança com **Spring Security** e autenticação via tokens **JWT (JSON Web Tokens)**, garantindo que apenas usuários autenticados processem cálculos ou acessem históricos.
* **Arquitetura Limpa:** Estruturação baseada no padrão **MVC (Model-View-Controller)** com forte separação de responsabilidades (Controllers, Services, Repositories e DTOs).

---

## ⚙️ Arquitetura e Tecnologias

* **Linguagem:** Java 17+
* **Framework:** Spring Boot
* **Segurança:** Spring Security + JWT
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** PostgreSQL (Produção) / H2 Database (Testes locais)
* **Validação:** Bean Validation
* **Infraestrutura/Deploy:** Render (Cloud)

---

## 🔒 Autenticação e Endpoints Principais

A API é protegida. Para acessar os endpoints de cálculo, é necessário primeiro obter um token JWT fazendo login.

### 1. Autenticação
* `POST /auth/register` - Cadastra um novo usuário.
* `POST /auth/login` - Autentica o usuário e retorna o **Token JWT**.

### 2. Cálculos de IRPF
Requer o envio do header: `Authorization: Bearer <SEU_TOKEN_JWT>`

* `POST /api/v1/irpf/calcular` - Recebe os dados financeiros e retorna o cálculo detalhado.

**Exemplo de Corpo da Requisição (JSON):**
```json
{
  "rendimentoTributavel": 6500.00,
  "deducoes": 500.00,
  "dependentes": 1
}
```

**Exemplo de Resposta (JSON):**
```
{
  "baseCalculo": 5810.41,
  "faixaAtingida": "Faixa 4 (22,5%)",
  "impostoDevido": 482.56,
  "aliquotaEfetiva": "7,42%"
}
```

🚀 Como Executar o Projeto Localmente
Pré-requisitos

    Java Development Kit (JDK) 17 ou superior instalado.

    Maven instalado.

    PostgreSQL instalado e rodando (opcional, pode ser configurado para H2 local).

Passo a Passo

   1- Clone o repositório:
    
    git clone [https://github.com/filipebalan/api-calculadora-irpf.git](https://github.com/filipebalan/api-calculadora-irpf.git)

  2-  Acesse a pasta do projeto:

    cd api-calculadora-irpf

3- Configure as variáveis de ambiente:
Renomeie o arquivo (application-dev.properties) e insira as credenciais do seu banco de dados e a sua chave secreta JWT.

4- Compile e execute a aplicação:
   ```
   mvn spring-boot:run
   ```
Acesse a API:
A aplicação estará disponível em http://localhost:8080.

👨‍💻 Autor

Filipe Balan

    LinkedIn: linkedin.com/in/filipebalan

    E-mail: filipebalan@gmail.com
