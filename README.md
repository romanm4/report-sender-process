# report-sender-process
This application is demonstrating how to implement complicate business process using Activiti BPMN

# Inside
This project is based on the Spring Boot project and uses these packages:

* [Maven](https://maven.apache.org/) - Dependency Management
* [Apache CXF](https://cxf.apache.org/) - Open-Source Services Framework
* [Activiti BPMN](https://www.activiti.org/) - Open Source Business Automation
* [ActiveMQ](https://activemq.apache.org/) - Flexible & Powerful Open Source Multi-Protocol Messaging
* [PostgreSQL](https://www.postgresql.org/) - Most Advanced Open Source Relational Database

# Running application step by step
1. Deploy project [gastronomy-calculate-booster](https://github.com/romanm4/gastronomy-calculate-booster) to Apache Tomcat. Required URL ```http://localhost:8091/gastronomy-calculate-booster```. **See application** [config file](https://github.com/romanm4/report-sender-process/blob/master/src/main/resources/application.properties).
2. Execute this command in project terminal
```
mvn clean install
```

```
mvn spring-boot:run
```

# Deployment to [Apache Tomcat](http://tomcat.apache.org/)
1. After execute ```mvn clean install``` command go to ***target*** folder
2. Copy ```report-sender-process-0.0.1-SNAPSHOT.war``` to ***C:\apache-tomcat-9.0.30\webapps***
3. Execute command ```catalina.bat run``` in ***C:\apache-tomcat-9.0.30\bin***

# Authors
* **Roman Maniev** - *Junior Integration Developer*, *Software Tester* - [romanm4](https://github.com/romanm4)
