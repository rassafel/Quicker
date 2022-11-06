FROM amazoncorretto:17
WORKDIR /opt/app/

ENV TZ=Etc/UTC \
    spring_profiles_active=docker \
    SERVER_PORT=80 \
    MANAGEMENT_SERVER_PORT=8081

EXPOSE ${SERVER_PORT}

ARG JAR_FILE=build/libs/*-boot.jar
COPY --chown=nobody ${JAR_FILE} application.jar

USER nobody

ENTRYPOINT ["java", "-jar", "application.jar"]
