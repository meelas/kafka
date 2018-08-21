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
ADD g1service /code/g1service
ADD p1service /code/p1service
ADD h1service /code/h1service

CMD ["mvn", "install"]