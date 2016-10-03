ASU ID : 1210448145  / rnihalan
NAME : RAVI NIHALANI
SOFTWARE DESIGN ASSIGNMENT 2 : RESTful CRUD Web Services Readme

********************************************************************************************************************************************
BUILD AND RUN INSTRUCTIONS :
********************************************************************************************************************************************

Follow the below instructions to install the project in Eclipse IDE :

1. Copy the CRUD-GradeBook-rnihalan-Eclipse.zip at any location on your local system . This zip file contains the project folder "CRUD-GradeBook-rnihalan-Eclipse" as well as Readme  "READ_ME_SD_ASSIGNMENT2.txt"

2. Unzip the file

3. Go to Eclipse and click on File -> Import --> General --> Existing Project into Workspace and click on Next

4. Check the "Select root directory" and click on "Browse" and select the unzipped folder CRUD-GradeBook-rnihalan-Eclipse in your local system and click on Open

5. Once done, the Projects section should show CRUD-GradeBook-rnihalan-Eclipse . If yes, click on Finish

6. The project has been successfully imported.

7. Now setup the Tomcat server in Eclipse by right clicking the "Servers" section at the bottom of Eclipse window.
   Select "Tomcat v7.0 Server" as the Server type,
   Type "localhost" as the Server's host name,
   Type "Tomcat v7.0 Server at localhost" as Server name, and
   Select "Apache Tomcat v7.0" as Server runtime environment
   
   Finally click on "Finish"
   
8. Now right click on the Project "CRUD-GradeBook-rnihalan-Eclipse" in the Project Explorer and click on 
	
	Run as --> 1 Run on Server 
   
9. The application will start running on the browser in Eclipse . Better, we can test on Chrome by putting the URL 
	http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/
	
	The above URL takes you to the home page of the project.
	
	By accessing the following URL, you can access the gradebook resource : http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook
	

********************************************************************************************************************************************
PROJECT WORKING :
********************************************************************************************************************************************

On the homepage of the project  : 

The menu allows you to select between Instructor mode and Student mode.

By clicking the radio button next to the Instructor ,"Instructor mode" is activated while the radio button next to Student activates the "Student mode".
Instructor mode is selected by the Instructor only and Student mode by the Student.


The instructor has the power to perform the below operations :


a. CREATE : 
     
   --> Add Student 	
   								
   			  - Allows the instructor to create a new student by feeding unique numeric Student ID (not null) and any name (need not be unique).
   			  - If the Student ID provided already exists, then the server will not allow to create one more student and return a 409 Conflict status code

   --> Add Grade Item for all existing students 
      
   			  - Allows the instructor to add a Grade Item (e.g. Midterm) to all existing students already added in the gradebook using the previous option.
   			  - The instructor here needs to feed the GradeItem name (mandatory) and GradeItem weightage (mandatory) and click on Submit.
   			  - If the GradeItem provided already exists, then the server will return a 409 Conflict status code

b. READ : 
     
      Read gradebook 
      
      		  - This option allows the instructor to see the xml data of the gradebook.
      		  - Once the radio button is clicked, the Instructor has an option to see the complete gradebook by passing "ALL" or selecting a student ID to get student specific gradebook

c. UPDATE :
     
      Update a grade for a student with feedback 
      
      		  - This options allows the Instructor to grade a student for the recently submitted gradeitem (e.g. Midterm).
      		  - S/He can also update the weightage of the gradeitem or he can also give feedback to the student for his performance in this gradeitem
      		  - If the instructor is trying to grade for an incorrect combination of Student and GradeItem OR if the Student or the Gradeitem didn't exist then 400 BAD REQUEST response code is generated.

d. DELETE : 
     
      Delete a student  
      
      		  -  This option allows the Instructor to delete a Student by passing his existing Student ID . 
      		  -  If the Student ID entered is incorrect, then the server returns 400 BAD REQUEST response code 

      Delete a Grade Item from all students     	
      
      		-  This option allows the Instructor to delete a GradeItem assigned to all existing students, by passing the exact name of the GradeItem . 
      		-  If the GradeITem entered already exists, then the server returns 400 BAD REQUEST response code 

      Delete a Grade for a specific student
	        -  This option allows the Instructor to delete a GRade assigned to all any specific student, by passing the Student ID for whom the grade has to be deleted and the Grade ITem for which the grades are to be updated . 
      		-  If the GradeITem OR Student ID entered is incorrect, then the server returns 400 BAD REQUEST response code 
           

--> The student under the student mode can perform the following actions : 


a. READ : 
     
       Check your gradebook    
       
       		-  This option allows a specific Student to check his gradebook by just passing his Student ID


b. UPDATE :
     
       You think your grades are not fair? Why not to appeal
       
       		-  The appeal option, allows a student to appeal for the grades he has received.
       		-  Note that if the Student tries to appeal for a grade which hasn't even been posted by the professor, the server returns 400 BAD REQUEST response code
       		-  Similarly, if the Student passes an incorrect combination of Student ID and GradeItem, then also the server returns 400 BAD REQUEST response code
       		
       		
Note 1 : Every page throughout the project has one or multiple HOME hyperlinks that will take you to various modes directly

Note 2 : Very important : 

   After every request from either the Instructor/Student, the next page is a page with the SERVER RESPONSE DETAILS and ADDITIONAL DETAILS.
   The SERVER RESPONSE DETAILS , gives the information of the LOCATION, MEDIA TYPE and RESPONSE CODE returned by the server.
   These change as per every scenario.
   Below the SERVER RESPONSE DETAILS, I am also displaying Additional Details which detail as to what went correct or what went wrong at the server during processing the request.
   This section gives the user a better idea of what actually has happened behind the client.
   
   Other important thing is that the server returns a location on this page which when accessed via browser displays the gradebook's xml content.

   The xml data on this resource can either be accessed by copying the URL displayed in the Location (under "SERVER RESPONSE DETAILS" section )
   
   OR 
   
   I have added a hyperlink for your easy access to the xml directly (as shown below "Click me" is a hyperlink which redirects to the Location displayed in the "SERVER RESPONSE DETAILS" section)

////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
SERVER RESPONSE DETAILS : 

1. Response Code: 
201
 
2. Media Type:    
application/xml
 
3. Location:      
http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/
 
ADDITIONAL DETAILS : 

1. Link to see the location of xml returned by server : Click me 

2. Action just performed :

Grade item Midterm has been successfully added with weightage 25% into the gradebook for all students!


////////////////////////////////////////////////////////////////////////////////////////////////////////////

********************************************************************************************************************************************
ACCESSING RESOURCES using the URL : REST
********************************************************************************************************************************************

1. By default I have added two students information in the project , hence on trying to access the below URL , one can check the complete gradebook at any point of time :

URL    : http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook

OUTPUT : 

This XML file does not appear to have any style information associated with it. The document tree is shown below.
<students>
<student>
<student_id>1</student_id>
<student_name>Bruce Wayne</student_name>
<grade_item_details>
<appealed>Not-appealed</appealed>
<feedback>No feedback</feedback>
<grade>Task not graded yet</grade>
<grade_item>Midterm</grade_item>
<weigtage>25%</weigtage>
</grade_item_details>
</student>
<student>
<student_id>2</student_id>
<student_name>David Letterman</student_name>
<grade_item_details>
<appealed>Not-appealed</appealed>
<feedback>No feedback</feedback>
<grade>Task not graded yet</grade>
<grade_item>Midterm</grade_item>
<weigtage>25%</weigtage>
</grade_item_details>
</student>
<student>
<student_id>567</student_id>
<student_name>Dwayne Johnson</student_name>
<grade_item_details>
<appealed>Not-appealed</appealed>
<feedback>No feedback</feedback>
<grade>Task not graded yet</grade>
<grade_item>Midterm</grade_item>
<weigtage>25%</weigtage>
</grade_item_details>
</student>
</students>


2. For accessing a Student specific Graadebook, we just need to append a valid student ID at the end of the URL used for accessing complete gradebook : http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/{student_id}

URL for accessing gradebook of Student ID 1   : http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/1

OUTPUT : 

This XML file does not appear to have any style information associated with it. The document tree is shown below.
<student>
<student_id>1</student_id>
<student_name>Bruce Wayne</student_name>
<grade_item_details>
<appealed>Not-appealed</appealed>
<feedback>No feedback</feedback>
<grade>Task not graded yet</grade>
<grade_item>Midterm</grade_item>
<weigtage>25%</weigtage>
</grade_item_details>
</student>


3. For accessing a Student specific GradeItem in the Gradebook, we just need to append a valid Grade Item name after the Student ID at the end of the URL in previous section : http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/{student_id}/{grade_item_name}


URL for accessing gradebook of Student ID 1 for GradeItem Midterm   : http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/2/Midterm

OUTPUT : 

This XML file does not appear to have any style information associated with it. The document tree is shown below.
<student>
<student_id>2</student_id>
<student_name>David Letterman</student_name>
<grade_item_details>
<appealed>Not-appealed</appealed>
<feedback>No feedback</feedback>
<grade>Task not graded yet</grade>
<grade_item>Midterm</grade_item>
<weigtage>25%</weigtage>
</grade_item_details>
</student>



********************************************************************************************************************************************
ASSUMPTIONS :
********************************************************************************************************************************************

1. Very important : 

   After every request from either the Instructor/Student, the next page is a page with the SERVER RESPONSE DETAILS and ADDITIONAL DETAILS.
   The SERVER RESPONSE DETAILS , gives the information of the LOCATION, MEDIA TYPE and RESPONSE CODE returned by the server.
   These change as per every scenario.
   Below the SERVER RESPONSE DETAILS, I am also displaying Additional Details which detail as to what went correct or what went wrong at the server during processing the request.
   This section gives the user a better idea of what actually has happened behind the client.
   
   Other important thing is that the server returns a location on this page which when accessed via browser displays the gradebook's xml content.

   The xml data on this resource can either be accessed by copying the URL displayed in the Location (under "SERVER RESPONSE DETAILS" section )
   
   OR 
   
   I have added a hyperlink for your easy access to the xml directly (as shown below "Click me" is a hyperlink which redirects to the Location displayed in the "SERVER RESPONSE DETAILS" section)
   
   
////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
SERVER RESPONSE DETAILS : 

1. Response Code: 
201
 
2. Media Type:    
application/xml
 
3. Location:      
http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/
 
ADDITIONAL DETAILS : 

1. Link to see the location of xml returned by server : Click me 

2. Action just performed :

Grade item Midterm has been successfully added with weightage 25% into the gradebook for all students!


////////////////////////////////////////////////////////////////////////////////////////////////////////////
 

2. I have already fed the default database of the system with two students : (Student name : "Bruce Wayne" , Student ID : 1) and (Student name : "David Letterman" , Student ID : 2)

3. Student ID can only be numeric value

4. The instructor is only teaching one class, 

5. The gradebook maintains information on only one class,

6. The instructor creates, reads, updates and deletes gradebook entries one at a time

7. Input validations have been performed using Javascript.



********************************************************************************************************************************************
REFERENCES :
********************************************************************************************************************************************

1 . https://www.youtube.com/watch?v=xkKcdK1u95s&list=PLqq-6Pq4lTTZh5U8RbdXq0WaYvZBz2rbn

2.  http://javapapers.com/web-service/restful-services-crud-with-java-jax-rs-jersey/

3.  http://www.restapitutorial.com/lessons/httpmethods.html

4.  http://www.restapitutorial.com/httpstatuscodes.html

5.  http://www.vogella.com/tutorials/REST/article.html

6.  http://javapapers.com/java/restful-web-services-with-java-jax-rs-using-jersey/

7.  Stackoverflow for various javascript validations and html forms variations