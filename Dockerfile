FROM openjdk:8

COPY . /.
RUN wget https://services.gradle.org/distributions/gradle-4.0-bin.zip \
    && unzip gradle-4.0-bin.zip -d /opt \
    && rm gradle-4.0-bin.zip

ENV GRADLE_HOME /opt/gradle-4.0
ENV PATH $PATH:/opt/gradle-4.0/bin

RUN gradle build

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/solid-tdd-0.0.1-SNAPSHOT.jar"]
