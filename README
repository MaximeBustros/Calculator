# Commands
## command to build
mvn clean install

## command to run calculator glassfish server
cd calculator-bean
mvn embedded-glassfish:run

## command to run client
cd calculator-client
java -classpath $CLASSPATH:target/calculator-client-0.0.1-SNAPSHOT.jar:../calculator-bean/target/stateless-bean.jar enterprise.calculator_stateless_client/CalculatorStatelessJavaClient
