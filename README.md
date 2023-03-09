# Springboot_project
# Chat_Application
* This is a Java And springboot based chat_Application project. which show us the chat netween two users.
*In this project We design 3 Models
1. User -> fro conversation we need user
2.ChatHistory-> for storing chat between two user 
3. status for confirming the user is active or not

# Data Flow

# Controller
* Request make from postman come to the cotroller class and based on request type and endpoints its call methods in controller

# Service
* from Cotroller class service class methods are called . Service class is the vclass wehere we write the buisness logic.

# Repository
* From service class repository interface methods are called . Actually this mehtods are mainly JPA reposity and Crud repository methods but JPA repo is exctend by repository interface.

# Operations/Methods with its url and endpoints

Post/Createuser:http://localhost:8080/saveuser

Post/loginuser:http://localhost:8080/login

Getuser:http://localhost:8080/getuser

Deleteuser:http://localhost:8080/deleteuser{user_id}


updateuser:http://localhost:8080/updateuser(requestparam->userId)


Post/saveStatus:http://localhost:8080/savestatus


post/createChat:http://localhost:8080/savemassage

GetChats:http://localhost:8080/getchats  (requestparam->user1,user2);


# Build
* We use MVC architecture for design this project
* We use MYSQL database in this project
* we use LIst datastructure in this project

