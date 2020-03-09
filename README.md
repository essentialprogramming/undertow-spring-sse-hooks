# Undertow Spring Boot SSE Hook Server
This is an example of how to implement a SSE server in Spring Boot and send a SseEmitter on every hook update.

## Build
mvn install

## Local run from IDEA
* Open Edit Configuration -> add Application
* Add main class: com.sse.Server
* Working directory: <path>\undertow-spring-sse-hooks
* Use classpath of module: undertow-spring-sse-hooks
* JRE: 1.8

## Local run jar
java -jar target/undertow-spring-sse-hooks-1.0.0-SNAPSHOT.jar

## Install Ngrok
* Go to [Ngrok](https://dashboard.ngrok.com/get-started), download and install.
* Once you've started a local webserver (eg. localhost:8080), fire up ngrok by pointing it to the port where your local server is running: _ngrok http 8080_. The output will list a forwarding URL, which will point to your local server (eg. Forwarding  https://cd3ae581.ngrok.io -> http://localhost:8080 ).

## Configure Rest hooks
* Go to http://demo.resthooks.org/ and create an account.
* Open Hooks Subscription and create a new subscription with an event (eg. _contact.created_) and the URL return by Ngrok + endpoint to your POST request (eg. https://cd3ae581.ngrok.io/sse/sendHook).
* Open Contacts page and create a new contact. This action will send a POST request to our server with details about the contact created. The server will send the content to all clients subscribed at that moment.

Check results on http://localhost:8080/index.html