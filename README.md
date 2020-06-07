Spring Boot Coding Dojo
---

Welcome to the Spring Boot Coding Dojo!

### Introduction

This is a simple application that requests its data from [OpenWeather](https://openweathermap.org/) and stores the result in a database. The current implementation has quite a few problems making it a non-production ready product.

### The task

As the new engineer leading this project, your first task is to make it production-grade, feel free to refactor any piece
necessary to achieve the goal.

### How to deliver the code
Source code can be downloaded from[Git hub location](https://github.com/abhinav-jain09/coding-dojo-spring-boot.git)

###To build the source code there run the following command 
-mvn clean install -Denv=docker

###To make the application up and running run the following command 
-docker-compose up

Basic troublesoting 

Port are not available error .To kill the port 8080 first we need to find the process id and then kill the process which is running on port
lsof -i tcp:8080 -s tcp:listen 
Kill -9

Please send an email containing your solution with a link to a public repository.

>**DO NOT create a Pull Request with your solution** 

### Footnote
It's possible to generate the API key going to the [OpenWeather Sign up](https://openweathermap.org/appid) page.
