# 1st-Java-assignment---Avian-Flights
Console airline ticket booking system
This a complete beginner take on a task in school: 
 - design and implement a console system for a small travel agency;
 - the agency has bought for 62.5, 5 tickets on each 3 different routes (so a total of 15 tickets): London to Cluj, Paris to London and Rome to Madrid;
 - there should be implemented a way to keep track of agency's profit or loss; initial investment 15 tickets * 62.5=937.5
 - tickets are resold with starting price of 150; each time a ticket is sold, price increases with 28%
  example: 1st ticket=150
            2nd (on same route) =150+28%=192
            3rd (on same route) =192+28%=245.76, etc.
            tickets on other routes start from 150. Routes are independent from each other prices wise
  - implement an option check seats avilability by route
 - if a booking is cancelled, the correct acquisition price should be returned, price for next ticket will decrease by 28% and profit or loss adjusted accordingly
 - implement an option check seats availability by route
 - implement an option called “management” that displays profit or loss 
 - each booking should ask for customer’s details:
	  -first name
	  -surname
	  -DOB
	  -address
	  -telephone no
	  -email
	  -passport number
  - if customer/passenger is under 16 years old, parent's details will be required: full name and contact means telephone no and email
  - customer's/passenger's details will be stored in a hashmap
  - search to cancel booking will be done by passport number OR uniquely booking number generated at the time of booking
