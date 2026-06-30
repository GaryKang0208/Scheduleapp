Method : Post
Url : https:localhost8080/schedules
Request body:
{
  "title": String
  "contents":  String
  "author": String
  "passwrod": String
}

Response Body:
{
 id: Long
  "title": String
 "contents" : String
 "author" : String
 "Createdat": LocalDateTime
 "Modifiedat": LocalDateTime
}
Status code: 201 created , 404 bad request(password incorrect)
content type : application/json

Method : Get  (전체 조회)
Url: /schedules
no request body
Response Body:
[   
{
   id : Long (고유 id)
    "title": String
   "contents" : String
   "author" : String
   "Createdat": LocalDateTime
   "Modifiedat": LocalDateTime

   } 
  ]
   Status code: 200 ok , 404 not found(password incorrect)
   content type : application/json
 


 Method : Get  ( 단건 조회)
  Url: /schedules/{id}
  no request body
  Response Body:
  {
  id : Long (고유 id)
   "title": String
  "contents" : String
  "author" : String
  "Createdat": LocalDateTime
  "Modifiedat": LocalDateTime

}
Status code: 200 ok , 404 not found(password incorrect)
content type : application/json

Method : Put
Url: /schedules/{id}
Request body:
{
   "title": String
   contents:  String
   author: String
   passwrod: String
}

Response Body:
{
id: Long
  "title": String
  "contents" : String
   "author" : String
  "Createdat": LocalDateTime
  "Modifiedat": LocalDateTime
}
Status code: 200 ok , 404 bad request
content type : application/json


Method : Delete
Url: /schedules/{id}
Request body:
{
   password : String

}
Response Body:
{

}
Status code: 204 deleted , 404 bad request
content type : application/json
