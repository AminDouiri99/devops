From openjdk:11
copy ./target/tpAchatProject-1.0.jar tpAchatProject.jar
EXPOSE 8888
CMD ["java","-jar","tpAchatProject.jar"]

