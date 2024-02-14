# Spring AI Retrieval Augmented Generation with Ollama

This project contains a web service that will accept HTTP GET requests at
`http://localhost:8080/ai/rag`

There is optional `message` parameter whose default value is "What bike is good for city commuting?".


## Building and running

```
./mvnw spring-boot:run
```

## Access the endpoint

To get a response to the default request of "What bike is good for city commuting?"

```shell
http http://localhost:8080/ai/rag
```
A sample response is

```json
{
  "info": {},
  "text": "Both the SwiftRide Hybrid and the AgileEon 9X are good options for city commuting, as they are designed for daily commutes and recreational rides. They both have efficient electric assist, integrated lights, and components that provide a comfortable and reliable cycling experience. Ultimately, the choice depends on your personal preferences and needs."
}
```

Now using the `message` request parameter to ask about a specific bike.

```shell
$  http GET localhost:8080/ai/rag message=="Tell me some details about the SwiftRide Hybrid"
```

A sample response is

```json
{
    "info": {},
    "text": "The SwiftRide Hybrid is a versatile and efficient bike designed for riders who want a smooth and enjoyable ride on various terrains. It features a lightweight and durable aluminum frame, a powerful electric motor that offers a speedy assist, a removable and fully-integrated 500Wh battery, a 10-speed Shimano drivetrain, hydraulic disc brakes for precise stopping power, wide puncture-resistant tires for stability, and integrated lights for enhanced visibility. The bike is priced at $3999.99."
}
```

## Prerequisite

Set up [Ollama](https://github.com/ollama/ollama)

The Spring AI project defines a configuration property named `spring.ai.ollama.chat.options.model` and `spring.ai.ollama.embedding.options.model` for completion and embedding API accordingly, that you should set to the model names from your Ollama setup

> Running `ollama run tinyllama` will download a ~1GB docker image.
