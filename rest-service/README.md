#Spring Boot Rest Service Application

This application is a very basic rest service created using Spring boot

Dependencies used:

- `Spring Web`

Configuration :

- Port configured is `8181`

REST Endpoints:

- `GET` `/greeting`
  - Returns the json response as follows
  `{
    "id": <Number>,
    "content": "Hello, World"
    }`
  

- `GET` `/greeting?name=<UserName>`
  - Returns the json response as follows
  `{
  "id": <Number>,
  "content": "Hello, <UserName>"
  }`