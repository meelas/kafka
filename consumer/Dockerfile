FROM java:8-jdk

RUN mkdir /app
WORKDIR /app
ADD ./target/consumer-1.0.0.jar /app/
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/consumer-1.0.0.jar", "--spring.profiles.active=dev"]
EXPOSE 8181