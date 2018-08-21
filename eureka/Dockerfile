FROM java:8-jdk

RUN mkdir /app
WORKDIR /app

ADD ./target/EurekaServer-1.0.0.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/EurekaServer-1.0.0.jar"]

EXPOSE 8082