FROM eclipse-temurin:17-jre
WORKDIR /opt/app/

ENV TZ=Etc/UTC \
    spring_profiles_active=docker \
    SERVER_PORT=80 \
    MANAGEMENT_SERVER_PORT=8081

EXPOSE ${SERVER_PORT}

RUN addgroup --system --gid 1001 spring \
    && adduser --system --uid 1001 quicker --gid 1001

RUN apt-get update \
    && apt-get install -y --no-install-recommends curl jq \
    && rm -rf /var/lib/apt/lists/*

ARG JAR_FILE=build/libs/*-boot.jar
COPY --chown=1001:1001 ${JAR_FILE} application.jar

USER quicker

ENTRYPOINT ["java", "-jar", "application.jar"]

HEALTHCHECK \
    --start-period=30s --interval=30s --timeout=3s --retries=3 \
    CMD curl --silent --fail --request GET \
    http://localhost:${MANAGEMENT_SERVER_PORT}/actuator/health \
    | jq --exit-status '.status == "UP"' || exit 1
