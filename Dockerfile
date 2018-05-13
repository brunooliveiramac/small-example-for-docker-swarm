FROM openjdk:8
ADD build/libs/solid-tdd-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "solid-tdd-0.0.1-SNAPSHOT.jar"]