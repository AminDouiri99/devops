From openjdk:8
copy ./target/achat-1.0-SNAPSHOT.jar achat-1.0-SNAPSHOT.jar
CMD ["java","-jar","achat-1.0-SNAPSHOT.jar"]
