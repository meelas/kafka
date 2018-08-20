FROM java:8

RUN apt-get update

RUN apt-get install -y maven

RUN ls -l

CMD ["echo", "Start"]