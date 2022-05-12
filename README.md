# Drone-Rest-Api
Spring boot rest api

#Build
After cloning the repository to favourite ide, ensure to reload pom file to install dependiencies
then run below command to get a jar file
./mvnw clean package

#Run
execute this command

java -jar target/drone-0.0.1-SNAPSHOT.jar


#Tests
1.registering a drone
endpoint:
http://localhost:8080/drone/register
method: post
raw body -JSON, headers= Content-Type:application/json
requestBody:

{
    "serial_number":"XXXL",
    "model_capacity":480,
    "weight_capacity":"Heavyweight",
    "battery_capacity":0.5,
    "state_status":"IDLE"
}

responseBody:

{
    "id": 20,
    "serial_number": "XXXL",
    "model_capacity": 480,
    "weight_capacity": "Heavyweight",
    "battery_capacity": 0.5,
    "state_status": "IDLE"
}


2.loading a drone with medication items
endpoint:
http://localhost:8080/dispatch/load
method: post
raw body -JSON, headers= Content-Type:application/json
request body

{
    "serial_number":"XEQDPPPFTO",
    "medicine_code":"PPS",
    "destination":"AFRICA",
    "source":"AMERICA",
    "status":"LOADING"
}

response body

{
    "serial_number": "XEQDPPPFTO",
    "model_capacity": 500,
    "weight_capacity": "Cruiserweight",
    "battery_capacity": 0.5,
    "medicine_name": "PANADOL",
    "medicine_weight": "34",
    "medicine_code": "PPS",
    "source": "AMERICA",
    "destination": "AFRICA",
    "status": "LOADING"
}

3.checking loaded medication items for a given drone
endpoint:
http://localhost:8080/dispatch/viewLoaded

requestBody:

form-data: serial_number:XEQDPPPFTO
method:post

responseBody:

[
    {
        "serial_number": "XEQDPPPFTO",
        "model_capacity": 500,
        "weight_capacity": "Cruiserweight",
        "battery_capacity": 0.5,
        "medicine_name": "PANADOL",
        "medicine_weight": "34",
        "medicine_code": "PPS",
        "source": "AMERICA",
        "destination": "AFRICA",
        "status": "LOADING"
    }
]


4.checking available drones for loading
endpoint:
http://localhost:8080/drone/available
method: post
no body/none

responseBody:

[
    {
        "id": 11000,
        "serial_number": "AMAAAMAYMK",
        "model_capacity": 200,
        "weight_capacity": "Lightweight",
        "battery_capacity": 0.9,
        "state_status": "IDLE"
    },
    {
        "id": 21000,
        "serial_number": "EODLVIDPOI",
        "model_capacity": 300,
        "weight_capacity": "Middleweight",
        "battery_capacity": 6.0,
        "state_status": "IDLE"
    },
    {
        "id": 31000,
        "serial_number": "XEQDPPPFTO",
        "model_capacity": 500,
        "weight_capacity": "Cruiserweight",
        "battery_capacity": 0.5,
        "state_status": "IDLE"
    },
    {
        "id": 41000,
        "serial_number": "EODLVQWTNL",
        "model_capacity": 400,
        "weight_capacity": "Heavyweight",
        "battery_capacity": 0.6,
        "state_status": "IDLE"
    }
]

4.check drone battery level for a given drone

endpoint:
http://localhost:8080/drone/givendrone
requestBody:
form-data:
serial_number:XEQDPPPFTO

responseBody:

{
    "serial_number": "XEQDPPPFTO",
    "battery_capacity": 0.5
}

