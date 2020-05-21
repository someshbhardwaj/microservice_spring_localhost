# microservice_spring_localhost

## Brief about the code or Tech Stack:
* Currency Exchange MySQL Microservice  and Currency Conversion Microservice talks via using Zuul API Gateway.

* Zuul API Gateway uses Eureka Name Server.

* Distributed Tracing done through Zipkin and Sleuth

* Hystrix used for Fault Tolerance,

* MySQL DB is used in the Currency Exchange MySQL Microservice => Exchange Value table is created using.

## Prerequisite
* One has to download the code.

* MySQL should be working.

* Create DB currency_exchange_value_db and table in it exchange_value

* Code for the same is in link: 
![DB Script](https://github.com/someshbhardwaj/microservice_spring_localhost/blob/master/Exchange_value.sql)

## For Distributed Tracing:
 Rabbit MQ is used. 
 Please download it at link:   ![RabbitMQ Dowload](https://www.rabbitmq.com/install-windows.html)
 Please install ErLang before installing rabbitmq.
 Once you have installed Rabbit MQ

For Running Rabbit MQ
In the console, go to the location where you have downloaded *zipkin-server-2.7.0-exec.jar
Execute below command (for Windows 10):

> set RABBIT_URI=amqp://localhost

> java -jar zipkin-server-2.7.0-exec.jar

Eureka Name Server:

![Image of Eureka Name Server](https://github.com/someshbhardwaj/microservice_spring_localhost/blob/master/Eureka_Name_Server.png)

API Gateway:
![API Gateway](https://github.com/someshbhardwaj/microservice_spring_localhost/blob/master/API_Gateway_Server.png)

Currency Conversion Microservice
![Currecncy conversion](https://github.com/someshbhardwaj/microservice_spring_localhost/blob/master/Currency_Conversion.png)

Currency Exchange MySQL Microservice
![Currecncy Exchange MySQL](https://github.com/someshbhardwaj/microservice_spring_localhost/blob/master/currency_exchange_mysql.png)

DB
![MySQL DB Content](https://github.com/someshbhardwaj/microservice_spring_localhost/blob/master/DB_Content.png)

Distributed Tracing using Zipkin
![Zipkin](https://github.com/someshbhardwaj/microservice_spring_localhost/blob/master/ZipkinUntitled.png)

Checking code flow using  Zipkin and sleuth distributed tracing
![Code flow using Zipkin](https://github.com/someshbhardwaj/microservice_spring_localhost/blob/master/Zipkin_Flow.png)

## URL to test the code.
Zipkin	http://localhost:9411/zipkin/

Currency Converter Service - Direct Call	http://localhost:8100/currency-converter/from/USD/to/INR/quantity/10

Currency Converter Service - Feign	http://localhost:8100/currency-converter-feign/from/EUR/to/INR/quantity/10000

Currency Exchange Service MYSQL- 	http://localhost:9000/currency-exchange/from/EUR/to/INR http://localhost:8001/currency-exchange/from/USD/to/INR

Eureka -	http://localhost:8761/

Zuul - Currency Exchange & Exchange Services	http://localhost:8765/currency-exchange-service/currency-exchange/from/EUR/to/INR http://localhost:8765/currency-conversion-service/currency-converter-feign/from/USD/to/INR/quantity/10


