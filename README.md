# CarWala - Simple Microservices Project

This project has two microservices:

1. **Car Service** - runs on port 8081
2. **Phone Service** - runs on port 8082

The main microservice communication is:

```text
Client
  |
  | GET /cars/1/offer
  v
Car Service
  |
  | Feign Client
  | GET /phones/offer/{carPrice}
  v
Phone Service
  |
  v
Phone details
```

## Main example

If car ID `1` has a price of `2500000`:

```text
GET /cars/1/offer
```

Car Service finds car 1, gets its price, and sends that price to Phone Service through Feign Client.

Phone Service checks the price and returns the matching phone.

## APIs

### Car Service - 8081

- `POST /cars` - add a car
- `GET /cars` - get all cars
- `GET /cars/{id}` - get one car
- `GET /cars/{id}/offer` - get the phone available with that car
- `PUT /cars/{id}` - update a car
- `DELETE /cars/{id}` - delete a car

### Phone Service - 8082

- `GET /phones` - check service
- `GET /phones/offer/{carPrice}` - return a phone based on car price

## Why Feign?

Without Feign, we would manually create an HTTP request from Car Service to Phone Service.

With Feign, we only write:

```java
@FeignClient(name = "phone-service", url = "${phone.service.url}")
```

and:

```java
phoneClient.getPhone(car.getPrice());
```

Feign handles the HTTP call for us.
