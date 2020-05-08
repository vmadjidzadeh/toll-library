# Toll parking library

A toll parking contains multiple parking slots of different types :

● the standard parking slots for sedan cars (gasoline-powered)

● parking slots with 20kw power supply for electric cars

● parking slots with 50kw power supply for electric cars

20kw electric cars cannot use 50kw power supplies and vice-versa.

Every Parking is free to implement is own pricing policy :

- Some only bills their customer for each hour spent in the parking (nb hours * hour price)

- Some other bill a fixed amount + each hour spent in the parking (fixed amount + nb hours * hour price)

In the future, there will be other pricing policies

Cars of all types come in and out randomly, the API must :

- Send them to the right parking slot of refuse them if there is no slot (of the right type) left.

- Mark the parking slot as Free when the car leaves it

- Bill the customer when the car leaves.

---------
The main entry point of this API is **toll.service.ITollManager** interface

There is only one test class, [TollTest](https://github.com/vmadjidzadeh/toll-library/blob/master/TollManager/src/test/java/toll/TollTest.java), in which the process of booking, releasing/billing a slot is run.

A class with static fields is used as database, a more elaborated process would have been to add persistency with an XML file for instance but according to me, that was one the main point of this API.

Also some external libraries like Lombok could have been used to enhance to visibility of the code.
