Check the POM file for needed changes flagged with comments.

In addition to making changes to the POM file, the module-info.java file was deleted from src/main/java since that information was moved to the POM. 


This includes the Java 21 workflow Jar. You can simply replace the jar file in \lib with the 24 version and then update the POM. (Directions will be provided in class on running multiple Java versions on one computer.)


With the workflow file in the lib directory, run this command to move the jar into the Maven repository:

mvn install:install-file -Dfile=lib/workflow-1.0-SNAPSHOT-jar-with-dependencies.jar -DgroupId=com.cs321 -DartifactId=workflow -Dversion=1.0-SNAPSHOT -Dpackaging=jar


Remember that the import statement is case sensitive so be sure to use this line with a capital W: 

import com.cs321.Workflow;


Use this command to run the application:

mvn clean javafx:run 





