# setup intellij , maven , tomcat , run first servlet program #


1. install intellij (zip>bin>idea64)
2. setup path for maven  3.3 and jdk 1.8
3. add dependancy for maven servlet  2.5
 
 https://mvnrepository.com/artifact/javax.servlet/servlet-api/2.5
 
 
 <!-- https://mvnrepository.com/artifact/javax.servlet/servlet-api -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>servlet-api</artifactId>
    <version>2.5</version>
    <scope>provided</scope>
</dependency>

copy this in pom.xml 

write the java code inside by creating folder java in src > package (com.java.servlet)
D:\JAVA_CODE_intellij\servlet-examples\servlet-helloworld\src\main\java\com\java\servlets\TestServlet.java

4.open terminal mvn clean install (it will generate target folder)
                mvn clean (it will delete target folder )               
                (after any changes in java file you have to do mvn clean > mvn clean install)
                
5. in Target folder go to D:\JAVA_CODE_intellij\servlet-examples\servlet-helloworld\target\servlet-helloworld.war 
6. copy the war file and paste in the  C:\Users\abhis\setup\apache-tomcat-8.5.69-windows-x64\apache-tomcat-8.5.69\webapps 
7. download tomcat 
8. tomcat>bin>cmd
9. start the server by catalina.bat run  (ctrl+c to stop the server)
10. open web browser http://localhost:8080/servlet-helloworld 
11. or  http://localhost:8080/servlet-helloworld/example 
12. stop the server 
