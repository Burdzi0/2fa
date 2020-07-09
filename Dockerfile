FROM openjdk:14-alpine
COPY build/libs/2fa-*-all.jar 2fa.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "2fa.jar"]