# Fetching latest version of Java
FROM openjdk:18
 
# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/counter-docker-0.0.1-SNAPSHOT.jar /app

# Exposing port 5000
EXPOSE 5000

# Starting the application
CMD ["java", "-jar", "counter-docker-0.0.1-SNAPSHOT.jar"]