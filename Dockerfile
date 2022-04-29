FROM eclipse-temurin:11-jre-alpine 
ADD target/convertcurrency-0.0.1-SNAPSHOT.jar convertcurrency.jar
EXPOSE 9001
ENTRYPOINT [ "java", "-jar" , "convertcurrency.jar"]
