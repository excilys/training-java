Training: computer-database    
===========================  

# Content
This training material holds a sequence of steps and features to implement in a Computer Database webapp.  
Here is the macro-planning and timeline of all milestones:  
 * t0    - Start of the project
 * t0+3  - Base Architecture, CLI (Add / Edit features), Logging
 * t0+11  - Web UI, Maven, Unit Tests, jQuery Validation, Backend Validation
 * t0+15 - Search, OrderBy, Transactions, Connection-Pool 
 * t0+20 - Spring integration
 * t0+24 - Spring MVC integration, JDBC Template, i18n
 * t0+31 - Maven Multi-modules, Spring Security, Hibernate ORM (JPA, Criteria, QueryDSL, Spring Data JPA)
 * t0+34 - Front (Angular JS, Angular or React)
 * t0+44 - Web Services, end of project
 * t0+48 - Project presentation to sales & tech audience

# Installation

## 1. Database
Create a local **MySQL** server.  
Execute scripts **1-SCHEMA.sql**, **2-PRIVILEGES.sql** and **3-ENTRIES.sql** in config/db.  
Schema created: **computer-database-db**
Tables created: **company, computer**  
User created: `admincdb`
with password: `qwerty1234`

## 2. IDE  
### 2.1. Eclipse  
- Add your project to the current workspace: **File** -> **Import** -> **Existing projects into workspace**    
- Create a new Tomcat 8.0 Server: Follow steps **[HERE](http://www.eclipse.org/webtools/jst/components/ws/M4/tutorials/InstallTomcat.html)**
- In your project properties, select **Project facets**, convert your project to faceted form, and tick **Dynamic Web Module** (3.0) and **Java** (1.8)
- Select **Runtime** tab (in the previous **project facets** menu)  and check the Tomcat 8.0 Server created above as your project runtime  

### 2.2. IntelliJ IDEA   
- Add your project to the current workspace: **Import Project**, select **Create project from existing sources**
- Create a new Tomcat 8.0 Server: **Run** -> **Edit Configurations** and point it to your local Tomcat directory (button **Configure...**) 
- Set project structure: In **File** -> **Project Structure**, add an Artifact with default options (Artifact tab)  

## 3. Git repository
- Create your own github account, and initialize a new git repository called "computer-database".  
- After the initial commit, add and commit a meaningful .gitignore file. 

You are ready to start coding.

## 4. Start coding
### 4.1. Layout
Your customer requested to build a computer database application. He owns about 500+ computers made by different manufacturers (companies such as Apple, Acer, Asus...).  
Ideally, each computer would contain the following: a name, the date when it was introduced, eventually the date when it was discontinued, and the manufacturer. Obviously, for some reasons, the existing data is incomplete, and he requested that only the name should remain mandatory when adding a computer, the other fields being filled when possible. Furthermore, the date it was discontinued must be greater than the one he was introduced.
The list of computers can be modified, meaning your customer should be able to list, add, delete, and update computers. The list of computers should also be pageable.  
The list of companies should be exhaustive, and therefore will not require any update, deletion etc...  

### 4.2. Command line interface client
The first iteration will be dedicated to implement a first working version of your computer database, with a CLI-UI.  
The CLI will have the following features:

- List computers  
- List companies  
- Show computer details (the detailed information of only one computer)  
- Create a computer  
- Update a computer  
- Delete a computer  

#### 4.2.1. Start
You will organize your project among several packages, such as model, persistence, service, ui, mapper...  
Please use Singleton patterns where it makes sense, and implement your own Persistence management layer (for connections).

#### 4.2.2. Pages
Now that your app's main features work, implement the pageable feature. We recommend the use of a Page class, containing your entities and the page information.  

#### 4.2.3. CODE REVIEW 1, logging (t0 + 3 days)
Important Points: Architecture (daos, mappers, services, models, exceptions etc...)? Singleton, IOC patterns? Validation (dirty checking?)? Date API? Secure inputs?  
Javadoc? Comments? Use Slf4j-api logging library, with the most common implementation: logback.  

### 4.3. CLI + Web interface client 
Now that your backend skeleton is working, we want to add a second more user-friendly UI, such as a Web-UI.  
As it will require more and more libraries (more JARs to include in the build path etc...), we should consider using a build manager. Moreover, testing is a very important aspect of QA, and testing libraries should be implemented before going any further, the same for logging.  
Then, you can work on implementing all features on the provided static pages, using JSTL, Tags, Servlets, JSPs...  

#### 4.3.1. Maven, Logging & Unit testing
Refactor your project tree to match maven standards. (Tip: you should exit eclipse, move folders around, and reimport your project using File -> Import -> Existing maven projects).  
Include necessary libraries such as mysql-connector, JUnit, Mockito, Slf4j, and create the test classes for the backend you have already developed (N.B.: This is against TDD best practices. You should always code your tests simulteanously while developing your features).  
Creating test classes implies to take into account ALL possibilities: Illegal calls, legal calls with invalid data, and legal calls with valid data.  
Add and configure the Maven checktyle plugin with the checkstyle.xml and suppressions.xml provided in config/checkstyle/

#### 4.3.2. Implement listing and computer add features in the web-ui
Using the provided template https://github.com/excilys/training-java/tree/master/static, integrate the previous features using Servlets, JSPs, JSTL.  
Use DTOs (Data Transfer Object) to transport only relevant data to the JSPs.  
Implement Computer listing (paginated), and add features. 
Warning: All features will be implemented and tested using Selenium automated with maven.  

#### 4.3.3. Secure through validation
Implement both frontend (jQuery) and backend validation in the web-ui.

#### 4.3.4. CODE REVIEW 2 (t0 + 11 days)
Important Points: Maven structure? Library scopes? Architecture (daos, mappers, services, models, dtos, controllers, exceptions, validators)? Validation? Unit test coverage? What about selenium integration into maven?  JSTL Tags and HTML documents structure.  
Prepare a point about Threading (Connections, concurrency), and Transactions.

#### 4.3.5. Connection pool, Transactions
Add a connection pool (HikariCP), put your credentials in an external properties file.  
Implement a solid transaction handling model.  

#### 4.3.6. Implement all other features in the web-ui
Implement Computer edit, delete, total count features.  
Warning: All features will be implemented and tested using Selenium automated with maven  

#### 4.3.7. Implement search and order by features
Search box can look for either computer or company objects.

#### 4.3.8. Add Company deletion feature in cli
In the command line interface, add a feature which deletes a company, and all computers related to this company. Warning: Using SQL CASCADE is forbidden. This implies the use of a transaction.  

#### 4.3.9. CODE REVIEW 3 (t0 + 15 days)
Important Points: Maven structure? Library scopes? Architecture (daos, mappers, services, models, dtos, controllers, exceptions, validators)? Validation? Unit test coverage? Search and order by design choices? JSTL Tags and HTML documents structure.  
Point about Threading (Connections, concurrency), and Transactions.

### 4.5. Embracing Spring Framework

#### 4.5.1. Spring
Enable the use of Spring to manage your objects's lifecycle, and transactions.  
Important: Be careful to use slf4j bridges to display spring logs. Do not forget to setup your logback configuration.  
Replace your connection pool by a real datasource configured in the spring context.  
Which problems did you encounter? Study and note all the possible ways of solving the dependency injection issue in servlets.  
Warning: Do not replace your Servlets by another class. Your controllers should still extend HttpServlet.

#### 4.5.2. CODE REVIEW 4 + Point overview: Spring integration (t0 + 20 days)
How a webapp is started, how spring initializes itself.  
Explanation of the common problems encountered with the different contexts.  
Roundtable of the solutions found, best practices.

#### 4.5.3. JDBCTemplate
Change your DAO Implementation and use the JDBCTemplate from spring-jdbc to make your requests

#### 4.5.4. Spring MVC
You can now forget about Servlets and use Spring MVC as Controller for your webapp.  
Use Spring MVC validation annotations to validate your DTOs.  
Add custom error pages.  

#### 4.5.5. i18n
Implement spring multilingual features (French/English).

#### 4.5.6. CODE REVIEW 5 (t0 + 24 days)
Important Points: How did you split your Spring / Spring MVC contexts? How to switch from a language to another? How about javascript translation? Did you use spring-mvc annotations, forms and models?

### 4.6. Multi module, ORM, and Security

#### 4.6.1. Hibernate
Add the Hibernate ORM to your project (managed by spring). You can choose the following APIs to implement it. HQL, JPA/Criteria, QueryDSL, Spring data JPA. 

#### 4.6.2. Maven multi-module
Now that your app is getting dense, it makes sense to split it into modules.  
Split your maven app into 6 different modules (we recommend exiting your IDE and making those changes by hand).  
Warning: you need to also split your applicationContext files: indeed, each module should be able to work as a standalone.  
Following modules can be created: core, persistence, service, binding, webapp, console.

#### 4.6.3. Security
Add Spring Security to your project. Choose a stateless approach, and use an extra UserDAO and related SQL table to store and retrieve user login info.  
Use Digest HTTP Auth.

#### 4.6.4. CODE REVIEW 6 (t0 + 31 days)
Important points: Which API was the most efficient for your queries? Limitations of those APIs.
Maven and Spring contexts evaluation, unit tests evaluation.

### 4.7. Web Services, REST API

#### 4.7.1. Jackson
Now, we want your webapp to also produce APIs so that clients could access the resources remotely.  
To allow the creation of AngularJS, Mobile (Android/iOS) or third party clients, you should expose all features using Jackson and Spring RestController.

#### 4.7.2. Jax WS / Jax RS
Refactor your CLI client to act as a remote client to your webapp, using either Jax-RS or Jax-WS libraries.

#### 4.7.3. CODE REVIEW 7 (t0 + 34 days)
Steps to fix before final release, code quality overview and possible improvements. AngularJs formation.

### 4.8. Front End
Create another project on your Github : **cdb-front**.

**cdb-front** is a Single Page Application (SPA) that enables the listing, creation, deletion and modification of compagnies for an admin user.

You must choose one of the 3 following frameworks (choose wisely) :
* AngularJs
* Angular
* React

This SPA must use the webservices you just created.

This SPA must be responsive. You can use any css library or create your own CSS.

Don't forget that this project is not on your tomcat, and that the address of your webservices may change from an environment to another.

#### 4.8.1 [Angular](https://angular.io/)

Angular is the rework of AngularJS framework. It's a brand new framework that is component oriented.

It is recommended to write code using [Typescript](https://www.typescriptlang.org/), a typed and object oriented Javascript. But you can still use latest Javascript.

##### [Angular-CLI](https://github.com/angular/angular-cli)
You can bootstrap your Angular project with Angular-CLI tools.

Angular-CLI provides you a pre-configured boilerplate project with all the tools generally used like Karma, Protractor and Jasmine for your tests, the compiler for Typescript and Sass and a first sample component.

For the use of Angular-CLI, we invite you to read the manual on the Angular-CLI github page.

##### Base architecture

In Angular, almost everything is a component, you must think your application like a house (which is a component, basically, your app.component) composed of walls (components too) which are themselves composed of bricks , etc ...
Each room of your house could be a module (see [documentation](https://angular.io/guide/architecture) for more informations)

We recommend you to follow the [style guide of John Papa](https://github.com/johnpapa/angular-styleguide/blob/master/a2/README.md) (same person than AngularJS style guide)

##### Usefull links
- [Angular Tower of Heroes Tutorial](https://angular.io/tutorial)
- [Angular Docs](https://angular.io/guide/architecture)
- [Angular Style guide](https://github.com/johnpapa/angular-styleguide/blob/master/a2/README.md)

#### 4.8.2 [React](https://reactjs.org/)

With React you will introduce yourself to functional programming, latest JS features, and highly scalable single page apps.

##### Components

React is the view layer of your SPA.

As with angular [create-react-app](https://github.com/facebookincubator/create-react-app) will allow you to bootstrap a React app with (almost) no pain.

Drop some [react-bootstrap](http://react-bootstrap.github.io/) or [material UI](http://www.material-ui.com/#/) in it, and you'll be good to go.

Then, you will have to look at the UI you want to build, and separate it in components. You can look at the concepts of smart/dumb containers/components.

Here's my advice :
- Make small, reusable and logic-free components. Put them in "components" directory. (Your UI library will already provide you a lot of them)
- Make business-aware and complex components. Put them in "containers" directory.
- Make layout components which organizes the components in page. Put them in "page" directory.

Maybe [this](http://havesome-react.surge.sh) will help.

API calls: axios
Tests: Jest, enzyme, look at snapshot tests. [cheatsheet](https://gist.github.com/yoavniran/1e3b0162e1545055429e)

##### [Redux](http://redux.js.org/)

Redux concept is not bound to React, but you'll hardly make an interesting application without a simple way to manage the data you display. I said simple. Not easy...

Consider spending some time to understand redux before continuing. Maybe [this](http://havesome-redux.surge.sh/) will help.

When you got it, you can use [ducks](https://github.com/erikras/ducks-modular-redux) architecture (like re-ducks with English accent) to organize your files.
And follow the [Flux Standard Action](https://github.com/acdlite/flux-standard-action) convention for creating your actions.

Use react-redux to connect your components to redux.
Use redux-thunk to make asynchronous action dispatch.

NB: Page's role can also be extended to make the call to the API to hydrate the page on load. For example, you want to display edit page. You need the current data, so you'll want to load it in the first place. You can dispatch an action hydrate your store (copy a portion of the db) in the componentDidMount lifecycle hook.

#### 4.8.3 [VueJS](https://vuejs.org/)


### 4.9. Final refactoring, UX, and project presentation
The final stage is your production release.

#### 4.9.1. UX
This is where you will think UX first, challenge the technical choices of the base page template, and customize it to your standards.

### 4.9.2. Final Presentation (t0 + 48 days)

Goal: Present a release that can be roll out for users. Keep in mind that your CDB is to replace something manual or based on a Excel Sheet. Your audience is mainly functional not technical.

The presentation will be made with the whole group, on one project of their choice.  
It consists of 3 parts:  
The product-presentation, from a user-centered perspective (non-technical). 
You are presenting your "Computer database" product, and telling us what it does and how it was made.  
A live-demonstration. Be careful, the audience may interrupt your demo and ask you to try / show something else.  
A technical review: you will reassure your client on what he paid for. Give him the necessary technical data and metrics which will allow him to think "they are competent and they did the job, and I am confident that it is maintainable and well coded".

**Warning**: this presentation is not a restitution of what you have done. It is a **simulation** of the presentation of a project you would deliver to your customer.

# 5. Optional modules

## 5.1. Threadlocal (2 days)
Replace existing connection logic with a ThreadLocal object. 

## 5.2. Performance Challenge with Gatling (3 days)
Now is the time to start evaluating your global application performance with a stress-test campain.
Using Gatling, you have one day to stress-test your web application (gatling test and directions present in the folder gatling-test) and use tools like VisualVM to improve the performances. See the relevant README file for more explanations. For now, choose the simulation without Spring Security.

## 5.3. Continuous Integration / Continuous Delivery (6 days)
We want to setup a continuous integration/delivery  system for our webapp with [Jenkins](https://jenkins-ci.org/) and [Docker](https://www.docker.com). Each time we push on master we want Jenkins to retrieve the changes, compile, test on a specific environment, build and push the new image to a registry, then automatically deploy the new image on the Cloud.

### 5.3.1 Jenkins & Docker

Create two Docker images : 
- One to compile, test and package your webapp
- One for the MySQL containing you test data

The both will need to communicate so the unit tests can access to the tests data

Install and configure a Jenkins and create a job that starts the build process everytime a push is performed on master.

### 5.3.2 Your app in docker

Create two Docker images : 
- one for your webapp
- one for your MySQL in production mode 

Use DockerHub and configure your Jenkins so it pushes your images on DockerHub

### 5.3.3 Continuous Delivery
Create four Docker images: one for jenkins, one for compilation and tests, one for production (tomcat) and one for the mysql. Push them to DockerHub.

- Connect with your login to [Docker Cloud](https://cloud.docker.com/) 

- Create a [free account](https://aws.amazon.com/fr/free/) on Amazon Web Services.

- [Link](https://docs.docker.com/docker-cloud/getting-started/link-aws/) your Amazon Web Services account to deploy node clusters and nodes using Docker Cloud’s dashboard. Be careful when choosing the type of node on Docker Cloud, select 't2.micro' under the conditions of free AWS account.

- Observe the diagram below to properly configure the architecture of Docker containers to set up the continuous delivery:
![image](http://s32.postimg.org/iio0ls66t/Continuous_delivery.png)

- Below the activity diagram to figure out all the process:
![image](http://s32.postimg.org/ijyeykoyd/CDProcess_Diagram.png)

## 5.4. Android

Use your webservices already existing to desing an android app

## 5.5. Jooq

Replace your existing ORM with Jooq

## 5.6. Scala

Replace your existing back-end with Scala

## 5.7 Thymeleaf

Replace your existing front-end with Thymeleaf

## 5.8 Microservices

Split you back-end into microservices

## 5.9 Batches
