FROM gradle:jdk-alpine

USER root

ADD . /root

WORKDIR /root

EXPOSE 8080

CMD ["gradle", "bootRun"]