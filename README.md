=======
# spring-boot-auth-jwt
### JWT Authentication on Spring Boot API
POC Sécurisation Service REST avec JWT

How to secure Spring Boot RESTful APIs with JWTs (JSON Web Tokens). 
Based on https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/

#### How to start the application

```
mvn spring:run
```

#### Try a GET request to see the (empty) list of tasks

###### HTTP 403 Forbidden status is expected

```
> curl http://localhost:8181/tasks

{"timestamp":"2018-03-14T03:47:49.239+0000","status":403,"error":"Forbidden","message":"Access Denied","path":"/tasks"}%    
```

#### Registers a new user

```
curl -H "Content-Type: application/json" -X POST -d '{
    "username": "admin",
    "password": "password"
}' http://localhost:8181/users/sign-up

```


####  logs into the application 

###### JWT is generated

```
curl -i -H "Content-Type: application/json" -X POST -d '{
    "username": "admin",
    "password": "password"
}' http://localhost:8181/login


HTTP/1.1 200 
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTUyMTg2MzMwM30.gmuKOj-nGz6CS-Cisgv-38UZe5tw4AMa80KFWsr6D6yfIaq5eNAbNhi9zveQfyOK1hyyLTqkVpl7SRNPoZDmaA
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Length: 0
Date: Wed, 14 Mar 2018 03:48:23 GMT

```

#### Issue a POST request, passing the JWT, to create a task
###### Remember to replace xxx.yyy.zzz with the JWT retrieved above
```
curl -H "Content-Type: application/json" \
-H "Authorization: Bearer xxx.yyy.zzz" \
-X POST -d '{
    "description": "Buy watermelon"
}'  http://localhost:8181/tasks

```

#### issue a new GET request, passing the JWT
###### remember to replace xxx.yyy.zzz with the JWT retrieved above

```
curl -H "Authorization: Bearer xxx.yyy.zzz" http://localhost:8080/tasks
```

