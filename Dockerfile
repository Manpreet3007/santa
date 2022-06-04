FROM openjdk:11
EXPOSE 8080
ADD target/santa-inc.jar santa-inc.jar
ENTRYPOINT ["java","-jar","/santa-inc.jar"]