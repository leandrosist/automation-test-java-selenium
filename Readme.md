# 🚀 Framework de Automação Java + Selenium + Allure

![Test Status](https://github.com/leandrosist/automation-test-java-selenium/actions/workflows/tests.yml/badge.svg)
[![Relatório Allure](https://img.shields.io/badge/Allure%20Report-Ver%20Resultados-green?style=for-the-badge&logo=allure)](https://leandrosist.github.io/automation-test-java-selenium/)

---

### 📊 Acompanhamento em Tempo Real
* **Último Relatório:** [Clique aqui para ver os resultados dos testes](https://leandrosist.github.io/automation-test-java-selenium/)
* **Status da Esteira:** Veja o progresso da execução na aba [Actions](https://github.com/leandrosist/automation-test-java-selenium/actions).


Este projeto utiliza Java, Selenium WebDriver e Cucumber para automação de testes Web, com relatórios avançados gerados pelo Allure Report  e execução via GitHub Actions.

📋 Pré-requisitos
1. Java JDK 17

   Variáveis de Ambiente: Configure JAVA_HOME e adicione %JAVA_HOME%\bin ao seu Path.

2. Maven

   Variáveis de Ambiente: Adicione o caminho da pasta bin do Maven ao seu Path.

   Validação: Digite mvn -version no terminal.

🛠️ Tecnologias e Dependências

    Java 17

    Selenium 4.16.1

    Cucumber 7.15.0 (BDD)

    Allure Cucumber 7 (Relatórios)

    AspectJ Weaver 1.9.20.1 (Agente de captura de dados)

🏃 Como Executar os Testes

Existem duas formas principais de execução:
1. Via IntelliJ (Modo Desenvolvimento)

   Vá em src/test/java/runner/RunTest.java.

   Clique com o botão direito e selecione Run 'RunTest'.

2. Via Terminal (Modo Profissional / CI)

Para rodar todos os testes e limpar resultados anteriores:
PowerShell

mvn clean test

Para rodar apenas um cenário específico via Tag:
PowerShell

mvn clean test "-Dcucumber.filter.tags=@CT01"

📊 Relatórios Visuais (Allure Report)

O Allure transforma os dados brutos da execução em um dashboard interativo.
1. Gerar e Abrir o Relatório

Após a execução dos testes (mvn test), execute o comando abaixo para abrir o relatório no seu navegador:
PowerShell

mvn allure:serve

2. O que o relatório oferece:

   Dashboard: Visão geral de falhas e sucessos.

   Behaviors: Resultados organizados pelas Features do Cucumber.

   Attachments: Screenshots automáticos anexados em caso de falha (configurado nos Hooks).

📝 Estrutura de Pastas

    src/test/resources/features: Cenários em Gherkin.

    src/test/java/pages: Elementos e interações (Page Objects).

    src/test/java/steps: Implementação dos passos e Hooks.

    target/allure-results: Dados brutos gerados pelo teste (não editar).

⚠️ Troubleshooting (Soluções de Problemas)

    Erro "mvn não reconhecido": Verifique se o caminho do Maven está corretamente adicionado ao Path das Variáveis de Ambiente do Windows.

    Relatório Vazio: Certifique-se de que o plugin io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm está presente na classe RunTest.java.

    Erro de AspectJ: Se as dependências ficarem vermelhas no pom.xml, use o comando mvn dependency:resolve ou clique no ícone de "Reload" na aba Maven do IntelliJ.