From openjdk:8
copy ./target/tpAchatProject-1.0-SNAPSHOT.jar tpAchatProject-1.0-SNAPSHOT.jar
CMD ["java","-jar","tpAchatProject-1.0-SNAPSHOT.jar"]
