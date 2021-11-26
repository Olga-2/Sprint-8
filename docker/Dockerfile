# устанавливаем самую лёгкую версию JVM
FROM openjdk:8-jdk-alpine

WORKDIR /app/docker

# внешний порт, по которому наше приложение будет доступно извне
EXPOSE 8080

# указываем, где в нашем приложении лежит джарник
ARG JAR_FILE=./target/docker-0.0.1-SNAPSHOT.jar

# добавляем джарник в образ под именем rebounder-chain-backend.jar
ADD ${JAR_FILE} docker.jar

# команда запуска джарника
ENTRYPOINT ["java","-jar","docker.jar"]
CMD ["--spring.profiles.active=qa"]
