#!/usr/bin/env groovy

import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import groovy.json.JsonSlurper

//class ClientGETAPITest {

    // REST API GET call
    //static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/users"))
                .GET()
                .build();

        //println("request:"+request);
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            //println(response.body())
            JsonSlurper jsonSlurper = new JsonSlurper()
            ArrayList myObject = jsonSlurper.parseText(response.body())
            myObject.each{ it ->
                println "Name: ${it.name} ===>>> Email: ${it.email.toLowerCase()}"
            }
        }
    //}
//}
