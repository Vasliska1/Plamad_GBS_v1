# Spring Plamad_GBS_v1 [![Build Status]
## About Players

Players have 2 methods - save and foundById. 

We have views for add and upgrade Players - to see them enter "http://localhost:8080/player/{id}/edit"(upgrade) or "http://localhost:8080/player/add"(for add Players).

Also we have Api - for found player by Id ("http://localhost:8080/api/player/{id}") and add Player("api/player/new").


## About GameResult

GameResult have 3 methods - save, getBestScore - displays the list with best players, getBestScoreLastWeek -   displays the list with best players on last week(one player-one result).

We have views for list of the top 10 best players ("http://localhost:8080/top10Players"). 

Also we have Api - add gameResult ("http://localhost:8080/api/result/add"), show best players ("http://localhost:8080/api/topPlayers/{count}") and show best players for last week ("http://localhost:8080/api/topPlayersLastWeek/{count}")

## Running plamad locally
Plamad is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:


```
git clone https://github.com/spring-projects/Plamad_GBS_v1.git
cd Plamad_GBS_v1
./mvnw package
java -jar target/*.jar
```

You can then access plamad here: http://localhost:8080/

<img width="1042" alt="petclinic-screenshot" src="https://cloud.githubusercontent.com/assets/838318/19727082/2aee6d6c-9b8e-11e6-81fe-e889a5ddfded.png">

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

## In case you find a bug/suggested improvement for Spring Petclinic
Our issue tracker is available here: https://github.com/spring-projects/spring-petclinic/issues


## Database configuration

In its default configuration, Petclinic uses an in-memory database (H2) which
gets populated at startup with data. The h2 console is automatically exposed at `http://localhost:8080/h2-console`
and it is possible to inspect the content of the database using the `jdbc:h2:mem:testdb` url.

*Additional from Vasilisa: u can found url in console output "H2 console available at .... '*url*'"
 
A similar setup is provided for MySql in case a persistent database configuration is needed. Note that whenever the database type is changed, the app needs to be run with a different profile: `spring.profiles.active=mysql` for MySql.


## Working with PLamad in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 8 or newer.
* git command line tool (https://help.github.com/articles/set-up-git)
* Your preferred IDE 
  * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
  not there, just follow the install process here: https://www.eclipse.org/m2e/
  * [Spring Tools Suite](https://spring.io/tools) (STS)
  * IntelliJ IDEA
  * [VS Code](https://code.visualstudio.com)

### Steps:

1) On the command line
    ```
    git clone https://github.com/spring-projects/Plamad_GBS_v1.git
    ```
2) Inside Eclipse or STS
    ```
    File -> Import -> Maven -> Existing Maven project
    ```

    Then either build on the command line `./mvnw generate-resources` or using the Eclipse launcher (right click on project and `Run As -> Maven install`) to generate the css. Run the application main method by right clicking on it and choosing `Run As -> Java Application`.

3) Inside IntelliJ IDEA
    In the main menu, choose `File -> Open` and select the Plamad [pom.xml](pom.xml). Click on the `Open` button.

    CSS files are generated from the Maven build. You can either build them on the command line `./mvnw generate-resources` or right click on the `spring-plamda` project then `Maven -> Generates sources and Update Folders`.

    A run configuration named `PlamdacApplication` should have been created for you if you're using a recent Ultimate version. Otherwise, run the application by right clicking on the `PlamdaApplication` main class and choosing `Run 'PlamdaApplication'`.

4) Navigate to Plamad

    Visit [http://localhost:8080](http://localhost:8080) in your browser.


## Interaction with other open source projects

One of the best parts about working on the Spring Plamda application is that we have the opportunity to work in direct contact with many Open Source projects. We found some bugs/suggested improvements on various topics such as Spring, Spring Data, Bean Validation and even Eclipse! In many cases, they've been fixed/implemented in just a few days.
Here is a list of them:

| Name | Issue |
|------|-------|
| Spring JDBC: simplify usage of NamedParameterJdbcTemplate | [SPR-10256](https://jira.springsource.org/browse/SPR-10256) and [SPR-10257](https://jira.springsource.org/browse/SPR-10257) |
| Bean Validation / Hibernate Validator: simplify Maven dependencies and backward compatibility |[HV-790](https://hibernate.atlassian.net/browse/HV-790) and [HV-792](https://hibernate.atlassian.net/browse/HV-792) |
| Spring Data: provide more flexibility when working with JPQL queries | [DATAJPA-292](https://jira.springsource.org/browse/DATAJPA-292) |


# Contributing

The [issue tracker](https://github.com/spring-projects/spring-plamda/issues) is the preferred channel for bug reports, features requests and submitting pull requests.

For pull requests, editor preferences are available in the [editor config](.editorconfig) for easy use in common text editors. Read more and download plugins at <https://editorconfig.org>. If you have not previously done so, please fill out and submit the [Contributor License Agreement](https://cla.pivotal.io/sign/spring).

# License

The Spring Plamad sample application is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).
