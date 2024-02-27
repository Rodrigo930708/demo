# Demo

Project with Spring boot and H2 with two end points for get prices to products in the catalogs
Contains infotmation for products like prices, dates, currency and identifiers.

## Usage

Execute class SpringBootH2Application, an then go to the http://localhost:8080/h2-console/ to access a data base in H2

with this credentials:


```bash
JDBCURL: jdbc:h2:file:./data/demo
Username: sa
Password: password
```

## Consume Rest Services

You can use Postman for consume end points
The application is started in port 8080

This is the information to consume each one end Point

## GET /prices/read

This endpoint provide all prices and products in the data base

```bash
GET http://localhost:8080/prices/read
```

### Response

```bash
[
    {
        "brandId": 1,
        "startDate": "2020-06-14T05:00:00.000+00:00",
        "endDate": "2021-01-01T05:59:59.000+00:00",
        "pricelist": 1,
        "productId": 35455,
        "priority": 0,
        "price": 53.50,
        "currency": "EUR"
    },
    {
        "brandId": 1,
        "startDate": "2020-06-14T05:00:00.000+00:00",
        "endDate": "2021-01-01T05:59:59.000+00:00",
        "pricelist": 1,
        "productId": 35455,
        "priority": 0,
        "price": 53.50,
        "currency": "EUR"
    },
    {
        "brandId": 1,
        "startDate": "2020-06-14T05:00:00.000+00:00",
        "endDate": "2021-01-01T05:59:59.000+00:00",
        "pricelist": 1,
        "productId": 35455,
        "priority": 0,
        "price": 53.50,
        "currency": "EUR"
    },
    {
        "brandId": 1,
        "startDate": "2020-06-14T05:00:00.000+00:00",
        "endDate": "2021-01-01T05:59:59.000+00:00",
        "pricelist": 1,
        "productId": 35455,
        "priority": 0,
        "price": 53.50,
        "currency": "EUR"
    }
]

```

### Response 404
```bash
{
    "code": 404,
    "timestamp": "2024-02-27T12:32:17.633803",
    "message": "No prices found"
}
```

## GET prices/read-by-parameters

This endpoint provide all prices and products with parameters like productId,group,date
The prices of the product depend of dates and the end point need this information foe works
Additional end point return prices for priority


```bash
GET http://localhost:8080/prices/read-by-parameters
```

### Request

```bash
{

"productId" : 35455,
"group": 1,
"date": "2020-06-14 16:00:00"

}
```
### Response 200
```bash
{
    "productId": 35455,
    "group": 1,
    "price": 53.50,
    "startDate": "2020-06-14T05:00:00.000+00:00",
    "endDate": "2021-01-01T05:59:59.000+00:00"
}
```

### Response 404
```bash
{
    "code": 404,
    "timestamp": "2024-02-27T12:32:17.633803",
    "message": "No prices found"
}
```

### Response 400
```bash
{
    "code": 400,
    "timestamp": "2024-02-27T12:32:53.85757",
    "message": "All parameters are required"
}
```


## License
