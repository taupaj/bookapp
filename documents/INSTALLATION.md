## Installation

*	Default active profile is **`dev`**. When the application is running, **Liquibase** will create the necessary tables and system data along with sample data. In the **`dev`** profile.

<details open="open">
	<ul>
		<li><a href="#running-the-application-with-ide">Running the application with IDE</a></li>
		<li><a href="#running-the-application-with-maven">Running the application with Maven</a></li>
		<li>
			<a href="#running-the-application-with-executable-jar">Running the application with Executable JAR</a>
		</li>
		<li><a href="#running-the-application-via-docker-container">Running the application via docker container</a></li>
	</ul>
</details>

#### Running the application with IDE

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.arc.sbtest.SBtemplateApplication` class from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Intellij
     * File -> Open -> Navigate to the folder where you unzipped the zip
     * Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

#### Running the application with Maven

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
$ git clone https://github.com/Spring-Boot-Framework/Spring-Boot-Application-Template.git
$ cd Spring-Boot-Application-Template
$ mvn spring-boot:run
```

#### Running the application with Executable JAR

The code can also be built into a jar and then executed/run. Once the jar is built, run the jar by double clicking on it or by using the command

```shell
$ git clone https://github.com/taupaj/bookapp.git
$ cd bookapp
$ mvn package -DskipTests
$ java -jar target/bookapp-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```

To shutdown the jar, follow the below mentioned steps on a Windows machine.

*	In command prompt execute the **jcmd** command to print a list of all running Java processes
*	**Taskkill /PID PROCESS_ID_OF_RUNNING_APP /F** execute this command by replacing the **PROCESS_ID_OF_RUNNING_APP** with the actual process id of the running jar found out from executing the previous command