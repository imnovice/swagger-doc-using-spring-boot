# Swagger API Documentation using SpringBoot
An example of REST API Documentation using Spring Boot

### Thing that is required:
```
- MAVEN 3.x (3.6 was used here)
- JDK 1.8
- SpringBoot 2.2.x
- Any IDE (eclipse was used here)
```

## Steps to build and run
To build: `mvn clean package` <br />
To run: `java -jar target\swagger-doc-example-0.0.1-SNAPSHOT.jar`

## Sample API

**Method:** POST<br />
**URL:** http://localhost:8080/api/product/post<br />
**JSON Request:**<br />

```json
{
  "id": 2,
  "name": "Puma Shoe",
  "description": "A good running show for men and women",
  "price": 11.19,
  "status": "LIVE"
}
```


**Method:** GET<br />
**URL:** http://localhost:8080/api/products<br />
**JSON Response:**<br />

```JSON
[
    {
        "id": 2,
        "name": "Puma Shoe",
        "description": "A good running show for men and women",
        "price": 11,
        "status": "LIVE"
    }
]
```