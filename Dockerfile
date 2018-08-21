FROM java:8

RUN apt-get update

RUN apt-get install -y maven

RUN ls -l

WORKDIR /code

ADD pom.xml /code/pom.xml
ADD config /code/config
ADD consumer /code/consumer
ADD eureka /code/eureka
ADD producer /code/producer

CMD ["mvn", "install"]