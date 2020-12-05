# targetdemo
#

The application contains 3 Spring Boot Applications

1. productprice - For getting and updating price of product items

   GET URL: http://localhost:8083/products/<productid>/price - Get specific product's price
   POST URL: http://localhost:8083/products/<productid> - Update specific product's price
   
   
2. productname - For getting name of product items 

   GET URL: http://localhost:8082/products/<productid> - Get specific product's name

   
3. demo - Combines output from productprice and productname and shows
   complete product details. Product name comes from productname project and 
   Product price comes from productprice project 
   
   GET URL: http://localhost:8081/products/<productid> - Get specific product's complete details - name and price
   GET URL: http://localhost:8081/products - Get all products complete details - name and price
   
   
Pre-populated data
==================

1. It contains 5 products with ids 1,2,3,4,5 and with the following details 

a. Product 1 
------------

{
    "id": 1,
    "name": "A",
    "priceCurrencyList": [
        {
            "price": 100,
            "currencyCode": "A-usd"
        },
        {
            "price": 200,
            "currencyCode": "A-cad"
        }
    ]
}

b. Product 2
------------

{
    "id": 2,
    "name": "B",
    "priceCurrencyList": [
        {
            "price": 100,
            "currencyCode": "B-usd"
        },
        {
            "price": 200,
            "currencyCode": "B-cad"
        }
    ]
}

c. Product 3
------------

{
    "id": 3,
    "name": "C",
    "priceCurrencyList": [
        {
            "price": 100,
            "currencyCode": "C-usd"
        }
    ]
}

d. Product 4
------------

{
    "id": 4,
    "name": "D",
    "priceCurrencyList": [
        {
            "price": 100,
            "currencyCode": "D-usd"
        }
    ]
}

e. Product 5 
------------

{
    "id": 5,
    "name": "E",
    "priceCurrencyList": [
        {
            "price": 100,
            "currencyCode": "E-usd"
        }
    ]
}   


Unit Tests
==========

1. testGetProductPrice_success and testUpdateProductPrice_success in productprice project
2. testGetProductName_success in productname project
3. testGetProductDetailsComplete_success in demo project


Testing outputs
===============

1. Get Price
------------

URL: http://localhost:8083/products/5/price
Request Type: GET

Response

{
    "id": 5,
    "priceCurrencyList": [
        {
            "price": 100,
            "currencyCode": "E-usd"
        }
    ]
}


2. Update Price

URL: http://localhost:8083/products/5
Request Type: POST
Request Body:

        {
            "price": 20002,
            "currencyCode": "E-usd"
        }
		
Response

Nothing

-----------------------------------

Verify updated price

URL: http://localhost:8083/products/5/price
Request Type: GET

Response

{
    "id": 5,
    "priceCurrencyList": [
        {
            "price": 20002,
            "currencyCode": "E-usd"
        }
    ]
}


3.Get Product name

URL: http://localhost:8082/products/5
Request Type: GET

Response

{
    "id": 5,
    "name": "E"
}

4. Update Product name


URL: http://localhost:8082/products/5
Request Type: POST
Request Body:

{
    "id": 5,
    "name": "Ee"
}
		
Response

Nothing

-----------------------------------

Verify updated price

URL: http://localhost:8082/products/5
Request Type: GET

Response

{
    "id": 5,
    "name": "Ee"
}


5. Get Complete Product Details

URL: http://localhost:8081/products/5
Request Type: GET

Response

{
    "id": 5,
    "name": "Ee",
    "priceCurrencyList": [
        {
            "price": 20002,
            "currencyCode": "E-usd"
        }
    ]
}

6. Get all products and their details

URL: http://localhost:8081/products
Request Type: GET

Response

[
    {
        "id": 1,
        "name": "A",
        "priceCurrencyList": [
            {
                "price": 100,
                "currencyCode": "A-usd"
            },
            {
                "price": 200,
                "currencyCode": "A-cad"
            }
        ]
    },
    {
        "id": 2,
        "name": "B",
        "priceCurrencyList": [
            {
                "price": 100,
                "currencyCode": "B-usd"
            },
            {
                "price": 200,
                "currencyCode": "B-cad"
            }
        ]
    },
    {
        "id": 3,
        "name": "C",
        "priceCurrencyList": [
            {
                "price": 100,
                "currencyCode": "C-usd"
            }
        ]
    },
    {
        "id": 4,
        "name": "D",
        "priceCurrencyList": [
            {
                "price": 100,
                "currencyCode": "D-usd"
            }
        ]
    },
    {
        "id": 5,
        "name": "E",
        "priceCurrencyList": [
            {
                "price": 100,
                "currencyCode": "E-usd"
            }
        ]
    }
]


		
