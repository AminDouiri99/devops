From openjdk:8
copy ./target/tpAchatProject-1.0-RELEASES.jar tpAchatProject-1.0-RELEASES.jar
CMD ["java","-jar","tpAchatProject-1.0-RELEASES.jar"]
