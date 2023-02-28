# Springboot_project
# Weeklytest_26
Weekly_test_api

# Weekly_test_api

In this project we build api.In  this projet there is 5 models(Student,laptop, courses, book,adress) .Here we mainly focus on n onetoone, ManytoMany , Manytoone relationship and we performe some operations like create,delete, save/post, updating etc. In this project we use join colomn Annotation which connect two tables based on foregn key which we dicide. and also we use embedded anotation for not making extra table for adress its join with student .

# framework and languges
* Springboot framework is used
* Java is Used for code

# Data flows

* UI(postman or localhost 8080 made requests)

# 1 Cotroller
* Cotroller -> requestcome from ui and  execute mathod in cotroller based on end points. In controller various mathods are available Ex

Studet-> create:http://localhost:8080/savestudent

         get:http://localhost:8080/getstudent

         Update:http://localhost:8080/updatestudent/1

         Delete; http://localhost:8080/deletestudent/{student id} 
         (requestparam= student_id)


 Laptop-> create:http://localhost:8080/savelaptopt

         get:http://localhost:8080/getlaptop

         Update:http://localhost:8080/updatelaptop/{laptop_id}

         Delete; http://localhost:8080/deletelaptop (requestparam=laptop_id)

book-> create:http://localhost:8080/savebook


         get:http://localhost:8080/getbooks

         Update:http://localhost:8080/updateBook/(requesparam=Book_id)


         Delete;http://localhost:8080/deleteBook  

Courses->create:http://localhost:8080/savecourse


         get:http://localhost:8080/savecourse



         Update: http://localhost:8080/updatestudent/1
         


* form controller service methods are call where our main buisness logic is wriiten

# 2 service

* the methods are called and its get data from databse with help of repository layer

# 3 Repository 
repository layes is help to connect with database 

# used databse
->Mysql

# data Structure
->  ArrayList


