FROM gradle:4.3-jdk-alpine AS TEMP_BUILD_IMAGE
USER root

ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME

COPY . .

RUN chmod 755 $APP_HOME

RUN gradle build --stacktrace

FROM gradle:4.3-jdk-alpine
ENV ARTIFACT_NAME=InnoReports-Classification-Service-0.1.0.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/$ARTIFACT_NAME .
EXPOSE 8081


CMD ["java","-jar", "InnoReports-Classification-Service-0.1.0.jar"]