From openjdk:11
copy ./target/tpAchatProject-1.0.jar tpAchatProject.jar
CMD ["java","-jar","tpAchatProject.jar"]

