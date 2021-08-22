# APROG | NOT JUST CAKES | JAVA GROUP PROJECT
Group work held in the first semester of the degree in systems engineering of ISEP, within the scope of the curricular unit of **Algoritmia and Programming**. Final grade: 15

This project was developed in two iterations and the utterance was as follows.

-------------
## first iteration
The bakery *Not Just Cakes* has managed its sales based on a handwritten notebook. With the increasing demand for quality cakes, the business has been growing and the management decided to adopt information technology. The objective is to develop a computer application that records information related to sales and allows for obtaining some statistics based on it. 

The cakes are only sold through three vendors, Ana, Beatriz and Cláudio. A sale is always associated with a type of cake (Normal or Vegan), the amount of cakes sold and the total value of the cakes. A salesperson can make multiple sales because he can visit multiple customers.

Implement a Java application that allows you to provide the following features:

1. Read the sales data made by the three sellers. Each sales record has the following information: Seller, type of cake, quantity, total sale amount.
Example: ``` Ana Vegan 5 100 ```

2. Show the following statistics:
    * Percentage of sales by type of cake, Normal and Vegan;
    * Total amount of cakes sold;
    * Sellers and quantities of cakes that sold each type of cake, Normal and Vegan, presented by descending order of quantity;
    * The seller who made the sale with the highest value and its value;
    * Average amount of cakes per sale;
    * Average value per sale.

**The implementation should only use simple data structures and control-of-flow structures.**

---
## second iteration
The implementation must use indexed data structures (mono and multidimensional) and flow control structures. It should also simplify the reading of the code adopting a modular organization, through structuring by methods.
Consider using the following data structures to store the information:
  * Seller array;
  * Cake type array;
  * Array (matrix) amount of cakes and value.

---
### Example of input and the expected output data

**Input data:**

SELLER |   TYPE  |  QUANTITY | PRICE
-------|--------|---------|-----------
ANA       |Normal   |  8   |    80
CLÁUDIO  | Vegan      |2    |   28
CLÁUDIO  | Vegan     | 2     |  20
ANA      | Normal   |  8 |      72
BEATRIZ  | Normal  |   10 |     50
CLÁUDIO  | Normal |    7   |    49
ANA      | Vegan |     2    |   30
ANA      | Normal     10 |     80
CLÁUDIO  | Vegan    |  1  |     12
ANA      | Normal  |   5   |    35
CLÁUDIO  | Normal |    4    |   36
BEATRIZ  | Normal  |   5     |  45
CLÁUDIO  | Vegan  |    1      | 13
BEATRIZ  | Normal |    5       | 45
ANA      | Vegan    |  1 |      10
BEATRIZ  | Vegan    |  1  |     15
CLÁUDIO  | Vegan    |  2   |    22
ANA      | Normal  |   8    |   72
BEATRIZ  | Normal |    6     |  42
CLÁUDIO  | Vegan |     2      | 30

**Statistics generated:**
```
Percentage of sales by type of cake
=> Normal: 55%, Vegan 45%

Total amount of cakes sold
=> 90

Sellers and quantities of cakes that sold Normal-type cakes
=> Ana: 39, Beatriz: 26, Claudio: 11

Sellers and quantities of cakes that sold Vegan-type cakes
=> Claudio: 10, Ana: 3, Beatriz: 1

The seller who made the sale with the highest value and its value
=> Ana: €379

Average amount of cakes per sale
=> 4.5

Average value per sale
=> €39.30 
```
