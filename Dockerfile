FROM maven:3.6.3-jdk-8

WORKDIR /home/app

COPY . .

RUN mvn clean

ENTRYPOINT ["mvn","spring-boot:","run","-P","prod"]