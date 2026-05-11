# 📊 API REST - Calculadora de IRPF com Dashboard Analítico

<p align="left">
  <img src="https://img.shields.io/badge/STATUS-EM%20PRODU%C3%87%C3%83O-brightgreen?style=for-the-badge" alt="Status" />
  <img src="https://img.shields.io/badge/%E2%98%95%20JAVA-21-orange?style=for-the-badge" alt="Java 21" />
  <img src="https://img.shields.io/badge/%F0%9F%8D%83%20SPRING%20BOOT-3-brightgreen?style=for-the-badge" alt="Spring Boot 3" />
  <img src="https://img.shields.io/badge/%F0%9F%90%98%20POSTGRESQL-Persist%C3%AAncia-blue?style=for-the-badge" alt="PostgreSQL" />
  <img src="https://img.shields.io/badge/%E2%9A%99%EF%B8%8F%20JWT-Seguran%C3%A7a-black?style=for-the-badge" alt="JWT" />
</p>

> 🔗 **Deploy na Nuvem (Render):** [https://calculadora-irpf.onrender.com](https://calculadora-irpf.onrender.com)  
> 📄 **Documentação Interativa (Swagger):** [https://calculadora-irpf.onrender.com/swagger-ui.html](https://calculadora-irpf.onrender.com/swagger-ui.html)

---

## 💡 Sobre o Projeto

Esta é uma **API RESTful** desenvolvida para automatizar o cálculo das faixas de Imposto de Renda Pessoa Física (IRPF), traduzindo regras de negócio financeiras complexas em um serviço seguro, rápido e exato.

O objetivo principal do projeto é processar rendimentos e deduções, aplicando a progressividade das alíquotas fiscais e retornando um resumo analítico pronto para ser consumido por aplicações web ou dashboards financeiras.

---

## 🎯 Principais Desafios e Soluções

* **Exatidão Financeira:** Utilização rigorosa da classe `BigDecimal` do Java para evitar erros de arredondamento comuns em pontos flutuantes (`double` / `float`), garantindo precisão absoluta nos cálculos de centavos.
* **Segurança de Dados:** Implementação de camadas de segurança com **Spring Security** e autenticação via tokens **JWT (JSON Web Tokens)**, garantindo que apenas usuários autenticados processem cálculos ou acessem históricos.
* **Arquitetura Limpa:** Estruturação baseada no padrão **MVC (Model-View-Controller)** com forte separação de responsabilidades (Controllers, Services, Repositories e DTOs).

---

## ⚙️ Regras de Negócio Implementadas (Atualização 2026)

O motor da API está totalmente alinhado com as legislações vigentes para 2026:
* **Isenção Total (Até R$ 5.000,00):** Aplicação automática da isenção integral para rendimentos brutos mensais de até 5 mil reais.
* **Redução Progressiva:** Implementação do algoritmo legal de redução parcial para faixas de renda entre R$ 5.000,01 e R$ 7.350,00.
* **Tabela Progressiva Atualizada:** Faixa base de isenção ajustada para R$ 2.428,80 e deduções exatas por dependente (R$ 189,59).
* **Persistência Relacional:** Mapeamento JPA (`@ManyToOne`) que vincula de forma íntegra e automática o histórico de cada cálculo ao usuário autenticado.

---

## 🧪 Como Testar a API (Guia Rápido para Recrutadores)

A API é trancada e segura por padrão. Para testar o motor de cálculo diretamente pelo seu navegador utilizando a interface interativa do [Swagger UI](https://calculadora-irpf.onrender.com/swagger-ui.html), siga este passo a passo simples:

### 1. Crie um Usuário de Teste
* Expanda a rota pública `POST /api/usuarios`.
* Clique no botão **Try it out** e envie um JSON preenchendo `login` e `senha`.
* Clique em **Execute** para cadastrar no banco de dados.

### 2. Gere o seu Token JWT
* Expanda a rota pública `POST /api/login`.
* Envie as mesmas credenciais que acabou de cadastrar.
* Copie a string do token retornada no corpo da resposta.

### 3. Destranque a API
* No topo da página do Swagger, clique no botão **Authorize** (ícone de cadeado).
* Cole o token copiado no campo e clique em **Authorize**.

### 4. Calcule o Imposto
* Expanda a rota protegida `POST /api/irpf/calcular`.
* Clique em **Try it out**, preencha os dados de rendimento bruto, desconto do INSS e número de dependentes, e clique em **Execute**.
* A API processará a matemática das regras vigentes e devolverá o valor exato do imposto devido.

---

**Desenvolvido por Filipe Balan** [![LinkedIn](https://img.shields.io/badge/LinkedIn-Conectar-blue?style=flat&logo=linkedin)](https://www.linkedin.com/in/filipebalan)