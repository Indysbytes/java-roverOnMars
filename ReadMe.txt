 * How to run the app.
 *
 * I have used Netbeans 7.2 on an Ubuntu 12.04 LTS OS with JDK 1.7. and Maven 3.
 * 
 * I have used the "jacoco-maven-plugin" to do code coverage. If your maven cannot download simply remove from the pom.
 *
 * I have used the assembly pluggin so you can run this from the cmd line with Maven.
 * After extracting to a directory you should see:
 *       src
 *       pom.xml
 *
 * run Maven
 *  $ maven clean install
 *
 * then you should see the target directory.
 *       src
 *       pom.xml
 *       target
 * 
 * make sure the Rover-1.0-RELEASE.jar file is in the target directory and has run permissions. (sudo chmod +x target/Rover-1.0-RELEASE.jar)
 * then run the app supplying the instructions 
 *
 * $ java -jar target/Rover-1.0-RELEASE.jar Mars "FFL"
 *

