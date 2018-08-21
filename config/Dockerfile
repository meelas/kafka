FROM java:8-jdk

RUN mkdir /app
WORKDIR /app

ADD ./target/ConfigServer-1.0.0.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app//ConfigServer-1.0.0.jar"]

HEALTHCHECK --interval=10s --timeout=10s CMD curl -f http://10.17.14.94:8888/health || exit 1

EXPOSE 8888