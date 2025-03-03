# E-Commerce Payment System
## 16-chatgpt-product-e-commerce-user-management-ms-2

This is a micro service for user management. It is a CHATGPT e-commerce project.
The other microserver at this point is on payment - implementing strategy patten. 
The service saves the user and provide all crud operations to save the user.  

**The original requirement**

Create a Spring Boot application that allows users to select different payment methods (like Credit Card, PayPal, and Crypto) to pay for their cart total. The system should follow the Open/Closed Principle using the Strategy Pattern, and payments should be stored in an H2 database.

**Design changed**
To add an API gateway, to create a separate user management micro service and then use KAFKA or REST APIs to get user data for the payment service. 

 Java Design Patterns implemented:
 - DAO Pattern
 - Strategy Pattern in the payment strategy in separate concrete classes
 - Builder pattern implementation in ErrorResponse in GlobalException Handler
 - In this micro service implemented GlobalExceptionHandler with ErrorResponse object provided by SpringBoot and implemented **Builder Pattern**
 