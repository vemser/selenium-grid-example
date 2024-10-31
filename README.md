<div align="center">
    <img alt="VemSerDBC" src="https://img.shields.io/badge/Vem%20Ser%2014-00599C?style=for-the-badge">
    <img alt="DBC" src="https://img.shields.io/badge/DBC-00599C?style=for-the-badge">
    <img alt="Testng" src="https://img.shields.io/badge/TestNG-00599C?style=for-the-badge">
    <img alt="QA" src="https://img.shields.io/badge/QA-43B02A?style=for-the-badge">
    <img alt="SELENIUM GRID" src="https://img.shields.io/badge/Selenium%20Grid-43B02A?style=for-the-badge">
</div>

# Selenium Grid - Tech Up Challenge

## Objetivo

Implementar o Selenium Grid e explorar as possibilidades que ele oferece diante o Selenium.

## Estrutura do projeto

O projeto conta com:

- 15 testes de UI realizados no site https://automationpractice.pl
- Três XMLs pré-configurados para execução de testes paralelos utilizando TestNG, sendo eles:
  - `parallelTest1Node.xml:` Execução paralela de um browser e um teste por vez.
  - `parallelTest3Node.xml:` Execução paralela de três browsers simultâneos mas um teste por vez.
  - `parallelTest15Node.xml:` Execução paralela de três browsers e cinco testes simultâneos para cada.
- Um docker compose com as imagens recomendadas para o Selenium Grid no semestre 2/2024.

## Instalação

Para realizar a instalação do Selenium Grid, escolha uma das três maneiras de sua preferência:

### 1. Configuração via Docker

Clone o repositório em sua maquina local
```bash
git clone https://github.com/giovanifogarolli/VS14.git
```
Acesse o diretório do projeto
```
VS14/08-ProjetoEstudo/Selenium_Grid
```
Inicie o Docker
```bash
docker compose -f 'docker-compose' up
```
Após finalizar os testes, desligue e remova os containers
```bash
docker compose -f 'docker-compose' down
```

### 2. Configuração Standalone do Selenium Grid

Caso prefira simplificar a configuração do Selenium Grid, você pode optar pelo modo standalone, onde hub e node são executados juntos em uma única máquina.

1. Baixe o [servidor do Selenium](https://github.com/SeleniumHQ/selenium/releases/tag/selenium-4.25.0)

2. Execute o servidor Selenium no modo standalone:

    ```bash
    java -jar selenium-server-standalone-<version>.jar standalone
    ```

Essa configuração permite que você execute o Selenium Grid sem precisar configurar máquinas separadas para hub e node, facilitando o processo de automação localmente ou em pequenos ambientes de teste.

### 3. Configuração Distribuída do Selenium Grid

Para executar os testes em um ambiente distribuído com hub e nodes separados:

1. Baixe o [servidor do Selenium](https://github.com/SeleniumHQ/selenium/releases/tag/selenium-4.25.0)

2. Configure o Selenium Grid como hub e inicie os nodes:

    ```bash
    java -jar selenium-server-<version>.jar hub
    ```

   Em outra máquina ou terminal para o node:

    ```bash
    java -jar selenium-server-<version>.jar node --hub http://<hub-ip>:4444
    ```

   Substitua <hub-ip> pelo endereço IP do seu hub Selenium Grid.

## Estrutura do XML

O XML é estruturado de forma com que:

- Dentro da tag `Suite` é invocado um paralelismo nas tags de test, que representam os browsers.
- Dentro da tag `Test` é invocado um paralelismo nas tags de methods, que representam os testes.
- Dentro do escopo da tag `Test` é adicionado uma tag de `parameter`, que representa o valor do browser no Switch-Case no `BrowserService`.

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="TestNG com Grid" parallel="tests" thread-count="?">
    <test name="Teste Chrome" parallel="methods" thread-count="?">
        <parameter name="Browser" value="chrome"/>
        <classes>
            <class name="br.com.vemser.tests.LoginTest"/>
            <class name="br.com.vemser.tests.SignUpTest"/>
            <class name="br.com.vemser.tests.ForgotPasswordTest"/>
        </classes>
    </test>
    <test name="Teste Edge" parallel="methods" thread-count="?">
        <parameter name="Browser" value="edge"/>
        <classes>
            <class name="br.com.vemser.tests.LoginTest"/>
            <class name="br.com.vemser.tests.SignUpTest"/>
            <class name="br.com.vemser.tests.ForgotPasswordTest"/>
        </classes>
    </test>
    <test name="Teste Firefox" parallel="methods" thread-count="?">
        <parameter name="Browser" value="firefox"/>
        <classes>
            <class name="br.com.vemser.tests.LoginTest"/>
            <class name="br.com.vemser.tests.SignUpTest"/>
            <class name="br.com.vemser.tests.ForgotPasswordTest"/>
        </classes>
    </test>
</suite>
```

Logo, para uma situação onde queremos dois browsers e três testes simultâneos, alterariamos o XML para:

#### Suit:
```xml
<suite name="TestNG com Grid" parallel="tests" thread-count="2">
```
#### Test:
```xml
<test name="Teste XXXX" parallel="methods" thread-count="3">
```


## Configurando Docker - Paralelismo

Acesse o docker.compose.yml e adicione o seguinte argumento: <br>

`- SE_NODE_MAX_SESSIONS`:   Aumentar as sessões disponiveis para testes simultâneos, recomendado 3-5.

## Colaboradores

<table>
  <tr>
    <td><a href="https://github.com/giovanifogarolli"><img src="https://avatars.githubusercontent.com/giovanifogarolli" width="100px;" alt="Giovani Fogarolli"/><br /><sub><b>Giovani Fogarolli</b></sub></a></td>
    <td><a href="https://github.com/thalesxbrasileiro"><img src="https://avatars.githubusercontent.com/u/71534326?v=4" width="100px;" alt="Thales Brasileiro"/><br /><sub><b>Thales Brasileiro</b></sub></a></td>
    <td><a href="https://github.com/Wagner-Dev-Souza"><img src="https://avatars.githubusercontent.com/u/115811946?v=4" width="100px;" alt="Wagner Souza"/><br /><sub><b>Wagner Souza</b></sub></a></td>
  </tr>
</table>