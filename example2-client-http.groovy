#!/usr/bin/env groovy

import groovy.json.JsonSlurper

class Example {
   static void main(String[] args) {
      def response = new URL("https://jsonplaceholder.typicode.com/users").openConnection()
      def responseCode = response.getResponseCode()

      if (responseCode.equals(200)) {
         JsonSlurper jsonSlurper = new JsonSlurper()
         def myObject = jsonSlurper.parseText(response.getInputStream().getText())
         myObject.each{ it ->
             println "Name: ${it.name} ===>>> Email: ${it.email.toLowerCase()}"
         }
      }
   } 
}
