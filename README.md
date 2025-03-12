# Welcome

This project is for my CGI Summer Internship trial work. It is a web application designed to assist flight passengers with flight planning and seat selection recommendations on airplanes. The application back-end is built using Spring Boot.


## My database structure overview

My database contains 20 flights.
Each flight in my database contains 60 seats, distributed as follows:

* Rows 1A-1F, to 10A-10F.

Seating Information:

* Close to exit seats: 1A-1F and 10A-10F.
* Extra Legroom seats: 1A-1F and 6A-6C.

Seat Type:

* Window seats: In each row, the window seats are all labeled A and F (e.g., 1A, 2A, 1F, 2F, etc.).
* Middle seats: In each row, the middle seats are all labeled B and E.
* Aisle seats: In each row, the aisle seats are all labeled C and D.