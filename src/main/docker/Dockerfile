FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD backend-spring-boot-template-0.1.0.war app.war
RUN sh -c 'touch /app.war'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.war" ]
