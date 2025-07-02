# Basque Word Teacher App

## Overview

Basque Word Teacher App (name not final) is a Java Spring Boot backend project that provides an API for language learning, focusing on Basque vocabulary. The application offers a Basque “word of the day” feature and allows users to interact with an AI-powered chatbot to learn about the meaning, usage, and correct application of Basque words in context.

The backend is integrated with the Azure OpenAI API (GPT-3.5) to generate responses to user queries. This project lays the foundation for a larger Basque language learning platform and demonstrates cloud-based AI integration, API development, and backend architecture.

---

## Features
- RESTful API for retrieving a random Basque word (noun or verb) from a PostgreSQL database running in a Docker container, using Jakarta Persistence (JPA) with Spring Boot 
- Chat endpoint for sending questions about a specific Basque word to an AI assistant  
- Sentence checking endpoint (planned for future versions) to validate user-written sentences for grammaticality and naturalness  
- Modular, testable Spring Boot codebase  
- Integration with Azure OpenAI (GPT-3.5 Turbo)  
- Ready to connect with any frontend (web, mobile, etc.)  

---

## API Endpoints
	GET /api/random-word
Returns a random Basque word for vocabulary practice  
    
    POST /chat
Accepts a JSON body with a user message and returns a relevant AI-generated response  

Example POST request:
    
    {"message": "What does egun mean?"}

Example response:

    {"response": "Egun means 'day' in Basque."}

Future updates aims to provide contextual uses of each word, following case rules.

---

## Getting Started 
### Prerequisites
- Java 17 or later  
- Maven  
- An Azure OpenAI resource (with deployed GPT-3.5 model - I personally used Azure Student)  

### Configuration
Add an application.properties file in your resources folder with the configuration below:

    azure.openai.api.key= //your API key here
    azure.openai.endpoint= //https://YOUR_RESOURCE_NAME.openai.azure.com/
    azure.openai.deployment=gpt-35-turbo
    azure.openai.api.version=2023-05-15

---

## Project Structure
Main Spring Boot application and package  
    
    /src/main/java/com/eguneko/hitza/  

Configuration classes for Azure OpenAI  

    /config  

REST API controllers  

    /controller  

Core business logic (OpenAI integration, word selection)

    /service  

---

## TODO

- [x] Set up Spring Boot project
- [x] Add OpenAI integration
- [ ] Create frontend interface
- [ ] Write user documentation

---

## Author

Laurence Sevilla