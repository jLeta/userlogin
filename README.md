
# Requirements
The minimum requirements for this application:
- JDK 8
- Maven 3.2
- yarn 1.22.0

# Build and launch the application 
- execute ./build-and-start-app.sh in any bash command line tool.


# Persistance
- the application used in-memory H2 database there is no need to install an additional Database. 
- by default a user with username=admin and password=admin is inserted to the database. 

# Target the application
- go to http://localhost:8080 


# Feature improvement 
- build-and-start-app.sh script can be avoided by using maven plugin to build the frontend app. 
- the application can be containerized using docker. 

 
# Demo
login page
![login page](https://github.com/jLeta/images/blob/main/Screen%20Shot%202020-11-23%20at%2011.11.25%20PM.png?raw=true)

Detail page
![login page](https://github.com/jLeta/images/blob/main/Screen%20Shot%202020-11-23%20at%2011.15.46%20PM.png?raw=true)
