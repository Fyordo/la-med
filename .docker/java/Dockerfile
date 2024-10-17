# Используем официальный образ Gradle с JDK 17 в качестве базового образа
FROM gradle:7.4.1-jdk17 AS builder

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файлы конфигурации Gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Копируем исходный код проекта
COPY src /app/src

# Сборка приложения, пропуская тесты
RUN gradle clean build -x test

# Используем официальный образ OpenJDK для выполнения приложения
FROM openjdk:17-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный JAR файл из предыдущего этапа
COPY --from=build /app/target/*SNAPSHOT.jar la-med.jar

# Указываем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "la-med.jar"]
