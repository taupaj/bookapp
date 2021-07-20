<!-- TABLE OF CONTENTS -->
## Table of Contents

<details open="open">
   <ul>
      <li><a href="#eer-diagram">EER Diagram</a></li>
      <li>
         <a href="#files-and-directories-structure">Files and Directories Structure</a>
         <ul>
            <li><a href="#packages">Packages</a></li>
         </ul>
      </li>
   </ul>
</details>

## EER Diagram

*	EER Diagram

[![EER Diagram](images/eer.png)](images/eer.png)

### Packages

* 	`controllers` - APIs;
* 	`error` - to hold custom exception handling;
* 	`domain` - to hold our entities;
* 	`dto` - to hold our dto entities;
* 	`repository` - to communicate with the database;
* 	`service` - to hold business logic;
* 	`mapper` - to hold mappers logic;
* 	`filter` - to hold filters for more efficient object search;
* 	`util` - to hold our utility classes;

* 	`resources/` - Contains all the static resources, templates and property files.
* 	`resources/config/liquibase/` - Contains initial table structure & table data - used by liquibase.
* 	`resources/static` - contains static resources such as css, js and images.
* 	`resources/templates` - contains server-side templates which are rendered by Spring.
* 	`resources/templates/fragments` - contains reusable code fragments.
* 	`resources/templates/pages` - contains server-side templates built using fragments.
* 	`resources/application.yml` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

* 	`test/` - contains unit and integration tests

* 	`pom.xml` - contains all the project dependencies