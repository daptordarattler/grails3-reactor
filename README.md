# grails3-reactor
Sample application showing how to use the new Events api in grails with Reactor. This could be termed as a reproduction in grails of the sample code at spring https://spring.io/guides/gs/messaging-reactor/

## Getting started
Currently the application gets random quotes from http://www.iheartquotes.com/api , about 20 quotes and displays them in the console.

Simply running:
Make sure you have grails setup and run
```
grails run-app
```
Or you can just type:
```
./gradle run
```
 for linux, and 
 ```
 gradle.bat run
 ```
 for windows

## To Do
1. Integrate with spring-websocket to show update in web view
2. Implement web view to start event and show results on webpage
