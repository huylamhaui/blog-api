FROM maven:3.6.3-jdk-8

WORKDIR /home/app

RUN mvn clean

COPY . .

ENTRYPOINT ["mvn","spring-boot:","run","-P","prod"]