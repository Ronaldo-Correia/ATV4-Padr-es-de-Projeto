# 🛠️ Sistema Modular para Gerenciamento de Dispositivos Inteligentes (IoT)

FEITO POR: RONALDO CORREIA e MARCELO DE JESUS  

## 📌 Descrição  
Este projeto é o **núcleo back-end** de um sistema modular de Internet das Coisas (IoT), que gerencia dispositivos inteligentes (sensores e atuadores) utilizando padrões de projeto **GOF** e princípios **SOLID**.  

## 📂 Estrutura de Pacotes  
src/main/java/br/edu/ifba/iot/
│
├── Main.java                        # Classe principal do sistema
│
├── command/                         # Padrão Command
│   ├── Command.java
│   ├── LigarDispositivoCommand.java
│   ├── DesligarDispositivoCommand.java
│
├── core/                            # Núcleo do sistema
│   ├── events/                      # Padrão Observer
│   │   ├── Event.java
│   │   ├── EventType.java
│   │   ├── EventListener.java
│   │   ├── EventManager.java
│   │
│   ├── devices/                     # Interfaces e classes base de dispositivos
│       ├── Device.java
│       ├── Actuator.java
│       ├── Sensor.java
│       ├── LightBulbActuator.java
│       ├── TemperatureSensor.java
│
├── factory/                         # Padrões Factory Method / Abstract Factory
│   ├── DeviceFactory.java
│   ├── SensorFactory.java
│   ├── ActuatorFactory.java
│
├── strategy/                        # Padrão Strategy
│   ├── EventResponseStrategy.java
│   ├── ImmediateResponseStrategy.java
│   ├── DelayedResponseStrategy.java
│   ├── ValidatedResponseStrategy.java
│
└── singleton/                       # Padrão Singleton
    └── ConfigurationManager.java


---

## 🚀 Como Executar  

### 📌 Pré-requisitos  
- **Java 21+** instalado  
- **Maven** instalado  

---

### 💻 Compilando e Executando (Windows)  

```powershell
# 1. Abra o terminal (PowerShell ou CMD) na pasta do projeto
cd caminho\para\ATV4-Padroes-de-Projeto\projeto

# 2. Compile o projeto com Maven
mvn clean install

# 3. Rode a aplicação
java -cp target\classes br.edu.ifba.iot.Main
