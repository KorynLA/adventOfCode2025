## Overview

This project contains a Java application that performs [2025 advent of code](https://adventofcode.com/2025/about) daily coding challenges with their answers printed to the console.

## Install
- **Java** version 11 or higher: [Install JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Maven** (If you're using Maven): [Install Maven](https://maven.apache.org/install.html)
- A terminal or command prompt for executing commands.

## Steps to Run the Application

### 1. Clone the Repository
git clone https://github.com/KorynLA/adventOfCode2025.git \
cd adventOfCode2025

### 2. Compile the Java files
javac -d target/classes src/main/java/com/example/App.java src/main/java/com/example/Day*.java
### 3. Run the application from the root of the project
java -cp target/classes com.example.App
