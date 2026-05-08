# 📊 Calculadora de IRPF - API REST & Dashboard Analítico

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

Este projeto é uma solução completa (Back-end e Front-end) para o cálculo do Imposto de Renda Pessoa Física (IRPF), construída com foco em regras de negócio claras, Clean Code e precisão matemática. 

A aplicação recebe os dados do usuário, processa a faixa salarial de acordo com a tabela progressiva e devolve uma análise financeira detalhada através de uma API REST, que é consumida por um dashboard interativo.

## 🚀 Funcionalidades

* **Cálculo Preciso:** Lógica de negócio robusta utilizando `BigDecimal` no Java para evitar erros de arredondamento financeiro.
* **API RESTful:** Endpoints estruturados para recebimento de requisições HTTP via formato JSON.
* **Dashboard Interativo:** Interface front-end responsiva e com gráficos dinâmicos para visualização de dados.
* **Integração Completa:** Comunicação fluida entre o front-end (JavaScript/Fetch API) e o back-end (Spring Boot).
* **Conteinerização:** Projeto empacotado com Docker para garantir estabilidade em qualquer ambiente.

## 🛠️ Tecnologias Utilizadas

**Back-end:**
* Java 21
* Spring Boot
* Maven

**Front-end:**
* HTML5, CSS3, JavaScript
* Chart.js 

**Infraestrutura / Deploy:**
* Docker
* Render (Hospedagem em nuvem)

## 🌐 Acesso ao Projeto (Live)

A aplicação está hospedada na nuvem e pode ser testada diretamente pelo navegador:
👉 **[Acessar Dashboard Analítico](https://calculadora-irpf.onrender.com/)**

> **Nota:** Como o projeto está hospedado em uma instância gratuita, o servidor pode entrar em modo de hibernação após 15 minutos de inatividade. O primeiro acesso pode levar alguns segundos a mais para carregar.

## 💻 Como rodar localmente

Caso queira clonar o projeto e rodar na sua máquina, certifique-se de ter o **Java 21** e o **Maven** instalados.

1. Clone o repositório:
```bash
git clone https://github.com/filipebalan/api-imposto-renda.git
```
2. Entre na pasta do projeto
```
cd api-imposto-renda
```
3. Execute a aplicação via Maven:
```
./mvnw spring-boot:run
```
4. Acesse no seu navegador: http://localhost:8080

## 📡 Documentação da API

POST /api/imposto/calcular

Calcula o imposto retido e retorna a faixa e a alíquota.

**Corpo da Requisição (JSON):**
```
{
  "nome": "Filipe Balan",
  "email": "filipe@email.com",
  "documento": "123.456.789-00",
  "telefone": "86999999999",
  "endereco": "Teresina - PI",
  "rendaSalarial": 6500.00,
  "regimeDeTrabalho": "CLT"
}
```
**Resposta de Sucesso (200 OK):**
```
{
  "faixaSalarial": "Acima de R$ 4.664,68",
  "aliquotaAplicada": "27,5%",
  "impostoAPagar": 891.50
}
```
**Desenvolvido por Filipe Balan** Estudante de Análise e Desenvolvimento de Sistemas | Foco em Back-end

🔗 **Conecte-se comigo no LinkedIn** https://www.linkedin.com/in/filipebalan/
