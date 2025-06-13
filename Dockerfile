FROM eclipse-temurin:21
WORKDIR /app
COPY ./build/libs/*.jar gongbaek.jar
COPY ./src/main/resources/application.yml application.yml
CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar", "gongbaek.jar"]