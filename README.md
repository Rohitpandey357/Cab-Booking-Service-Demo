# Cab-Booking-Service-Demo
This is a demo app for cab booking service

There are three layers in the app:

1) Controller layer -> This layer talks to the other two layers and decides which methods to call and with what parameters.

2) Service layer -> This layer has the implementation of the business logic.

3) Model layer -> This layer stores the entities and the data we use in this demo app. 


You can run the solution by following the below steps:

1) Building the solution: To successfully build the solution run the following command in the main directory : mvn clean package

2) Testing the solution: To test the solution, run the following command in the main directory : mvn test

3) Running the solution: After successfully building the solution, go into the target directory by using the following command : cd target

Once you get into the target directory run the following command to run the solution on the input file : 
java -jar cabbookingservice-0.0.1-SNAPSHOT.jar <path_to_input_file>

There is a sampleinput.txt file in src/main/resources directory. You can try with that also.
