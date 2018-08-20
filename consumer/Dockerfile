FROM java:8-jdk

RUN mkdir /app
WORKDIR /app
COPY build/libs/consumer.jar /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/consumer.jar", "--spring.profiles.active=dev"]
EXPOSE 8181