FROM eclipse-temurin:11-jre-alpine 
ADD target/casestudy-0.0.1-SNAPSHOT.jar casestudy.jar
EXPOSE 9002
ENTRYPOINT [ "java", "-jar" , "casestudy.jar"]
