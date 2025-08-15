# 🛠️ Sistema Modular para Gerenciamento de Dispositivos Inteligentes (IoT)

FEITO POR: RONALDO CORREIA e MARCELO DE JESUS  

## 📌 Descrição  
Este projeto é o **núcleo back-end** de um sistema modular de Internet das Coisas (IoT), que gerencia dispositivos inteligentes (sensores e atuadores) utilizando padrões de projeto **GOF** e princípios **SOLID**.  

---

## 🚀 Como Executar  

### 📌 Pré-requisitos  
- **Java 21+** instalado  
- **Maven** instalado  

---

## 🛠 Tecnologias Utilizadas

- **Java 21** → linguagem de programação principal
- **Maven** → gerenciamento de dependências e build
- **Padrões de Projeto GOF Aplicados**:
  - **Factory Method / Abstract Factory** → criação de dispositivos
  - **Singleton** → gerenciador global de configuração
  - **Observer** → comunicação entre sensores e módulo de eventos
  - **Command** → encapsulamento de comandos
  - **Strategy** → diferentes estratégias de resposta a eventos
  - **Composite** → composição de elementos da interface
  - **Decorator** → aplicação de temas (modo dia/noite)

---
### 💻 Compilando e Executando (Windows)  

```powershell
# 1. Abra o terminal (PowerShell ou CMD) na pasta do projeto
cd caminho\para\ATV4-Padroes-de-Projeto\projeto

# 2. Compile o projeto com Maven
mvn clean install

# 3. Rode a aplicação
java -cp target\classes br.edu.ifba.iot.Main
