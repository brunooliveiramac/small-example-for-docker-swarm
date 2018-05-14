FROM openjdk:8

COPY . /app
RUN wget https://services.gradle.org/distributions/gradle-3.3-bin.zip \
    && unzip gradle-3.3-bin.zip -d /opt \
    && rm gradle-3.3-bin.zip

ENV GRADLE_HOME /opt/gradle-3.3
ENV PATH $PATH:/opt/gradle-3.3/bin

RUN gradle build

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app/build/libs/solid-tdd-0.0.1-SNAPSHOT.jar"]

