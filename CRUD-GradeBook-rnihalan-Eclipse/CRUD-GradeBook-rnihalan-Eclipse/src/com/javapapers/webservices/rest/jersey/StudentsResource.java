package com.javapapers.webservices.rest.jersey;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import sun.security.util.Length;

@Path("/gradebook")
public class StudentsResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	StudentService studentService;

	public StudentsResource() {
		studentService = new StudentService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Student> getAnimals() {
		return studentService.getStudentAsList();
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Student> getAnimalsAsHtml() {
		return studentService.getStudentAsList();
	}

	// URI: /rest/gradebook/count
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		return String.valueOf(studentService.getStudentsCount());
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createAnimal(@FormParam("student_id") String student_id,
			@FormParam("student_name") String student_name,
			@FormParam("grade_item") String grade_item,
			@FormParam("grade") String grade,
			@FormParam("idtoremove") String idtoremove,
			@FormParam("add_grade_item_for_all") String add_grade_item_for_all,
			@FormParam("weightage_for_all") String weightage_for_all,
			@FormParam("grade_item_toremove") String 	grade_item_toremove,
			@FormParam("student_id_up") String student_id_up,
			@FormParam("grade_item_up") String grade_item_up,
			@FormParam("weigtage_up") String weigtage_up,
			@FormParam("grade_up") String grade_up,
			@FormParam("feedback_up") String feedback_up,
			@FormParam("student_id_appeal") String student_id_appeal,
			@FormParam("grade_item_appeal") String grade_item_appeal,
			@FormParam("student_id_mygradebook") String student_id_mygradebook,
			@FormParam("student_id_gremove") String student_id_gremove,
			@FormParam("grade_item_gremove") String grade_item_gremove,
			@FormParam("student_id_ins") String student_id_ins,
			@Context HttpServletResponse servletResponse) throws IOException {
		
		PrintWriter out = servletResponse.getWriter();
		if (idtoremove != null) //delete student
		{
			System.out.println("Inside Delete Student");
			
			if(	studentService.studentExists(idtoremove) )
			{
				studentService.deleteStudent(idtoremove);
				out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
						+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
						+ "\"204\" readonly> <br>"
						+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
						+ "\"NOT APPLICABLE\" readonly><b> <br>"
						+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
						+ "NOT APPLICABLE"
						+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
						+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Student with Student ID <u>"+idtoremove+"</u> has been successfully deleted from gradebook ! </h3>"
						+ " </FORM></h2></DIV></BODY></HTML>");
			}
			else
			{
				out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
						+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
						+ "\"400\" readonly> <br>"
						+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
						+ "\"NOT APPLICABLE\" readonly><b> <br>"
						+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
						+ "NOT APPLICABLE"
						+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
						+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Student with Student ID <u>"+idtoremove+"</u> doesn't exist and hence 400 status code returned !</h3>"
						+ " </FORM></h2></DIV></BODY></HTML>");
			}
		}
		else if (add_grade_item_for_all !=null && weightage_for_all !=null) // Add GradeItem
		{
			System.out.println("Inside Add Gradeitem");
			
			
			if(	studentService.gradeItemExists(add_grade_item_for_all) )
			{
				out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
						+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
						+ "\"409\" readonly> <br>"
						+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
						+ "\"NOT APPLICABLE\" readonly><b> <br>"
						+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
						+ "NOT APPLICABLE"
						+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
						+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Grade itme <u>"+add_grade_item_for_all+"</u> already exists and cannot be recreated hence STATUS CONFLICT 409 status code returned !</h3>"
						+ " </FORM></h2></DIV></BODY></HTML>");
			}
			else
			{
					studentService.addGradeItem(add_grade_item_for_all,weightage_for_all);
					out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
					+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
					+ "\"201\" readonly> <br>"
					+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
					+ "\"application/xml\" readonly><b> <br>"
					+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
					+ "http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/"
					+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
					+ "1. Link to see the location of xml returned by server : <a href=\"/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/"+"\">Click me</a> <br><br>"
					+ "2. Action just performed : <h3 style=\"color:white; background-color:black;\">Grade item <u>"+ add_grade_item_for_all+"</u> has been successfully added with weightage <u>"+weightage_for_all+"</u> into the gradebook for all students! </h3>"
					+ " </FORM></h2></DIV></BODY></HTML>");
			}
			
			
		}
		else if (grade_item_toremove !=null ) //GradeItem Delete
		{
			System.out.println("Gradeitem delete");
			
			if(	studentService.gradeItemExists(grade_item_toremove) )
			{
				studentService.deleteGradeItem(grade_item_toremove);
				out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
				+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
				+ "\"204\" readonly> <br>"
				+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
				+ "\"NOT APPLICABLE\" readonly><b> <br>"
				+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
				+ "NOT APPLICABLE"
				+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
				+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Grade item <u>"+ grade_item_toremove+"</u> has been successfully deleted from the gradebook for all students! </h3>"
				+ " </FORM></h2></DIV></BODY></HTML>");
			}
			else
			{
						out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
						+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
						+ "\"400\" readonly> <br>"
						+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
						+ "\"NOT APPLICABLE\" readonly><b> <br>"
						+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
						+ "NOT APPLICABLE"
						+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
						+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Grade item <u>"+grade_item_toremove+"</u> doesn't exist and cannot be deleted hence 400 status code returned !</h3>"
						+ " </FORM></h2></DIV></BODY></HTML>");
			}

		}
		else if (student_id_up!=null && grade_item_up!=null)
		{
			System.out.println("Update Grades ");
			
			if(	studentService.student_gradeItemExists(student_id_up,grade_item_up) )
			{
				studentService.updateGradeItem(student_id_up,grade_item_up,weigtage_up,grade_up,feedback_up);
			out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
						+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
						+ "\"200\" readonly> <br>"
						+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
						+ "\"application/xml\" readonly><b> <br>"
						+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
						+ "http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/"+student_id_up+""
						+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
						
						+ "1. Link to see the location of xml returned by server : <a href=\"/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/"+student_id_up+"\">Click me</a> <br><br>"
						+ "2. Action just performed : <h3 style=\"color:white; background-color:black;\">Grades for Student ID <u>"+student_id_up+"</u> has been successfully updated in his gradebook ! </h3>"
						+ " </FORM></h2></DIV></BODY></HTML>");
			}
			else
			{
				out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
						+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
						+ "\"400\" readonly> <br>"
						+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
						+ "\"NOT APPLICABLE\" readonly><b> <br>"
						+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
						+ "NOT APPLICABLE"
						+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
						+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Gradebook couldn't be updated as Gradebook entry for Student ID <u>"+student_id_up+"</u> and GradeItem <u>"+grade_item_up+"</u> doesn't exist and hence  400 Bad Request status code returned !</h3>"
						+ " </FORM></h2></DIV></BODY></HTML>");
			}
			
		}
		else if (student_id_appeal!=null && grade_item_appeal!=null) // appeal
		{
			System.out.println("Appeal gradebook");
			
			
			if(studentService.grade_for_student_gradeItemExists(student_id_appeal,grade_item_appeal))
			{
				studentService.appealGradeItem(student_id_appeal,grade_item_appeal);
			out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
						+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
						+ "\"200\" readonly> <br>"
						+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
						+ "\"application/xml\" readonly><b> <br>"
						+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
						+ "http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/"+student_id_appeal+""
						+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
						
						+ "1. Link to see the location of xml returned by server : <a href=\"/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/"+student_id_appeal+"\">Click me</a> <br><br>"
						+ "2. Action just performed : <h3 style=\"color:white; background-color:black;\">Student with Student ID <u>"+student_id_appeal+"</u> has successfully appealed for his grades for Grade Item <u>"+grade_item_appeal+"</u> ! </h3>"
						+ " </FORM></h2></DIV></BODY></HTML>");
			
			}
			else
			{
				
				if (!studentService.student_gradeItemExists(student_id_appeal,grade_item_appeal) ) 
				{
					out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
							+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
							+ "\"400\" readonly> <br>"
							+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
							+ "\"NOT APPLICABLE\" readonly><b> <br>"
							+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
							+ "NOT APPLICABLE"
							+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
							+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Appeal couldn't be accepted as the combination of Student ID <u>"+student_id_appeal+"</u> and GradeItem <u>"+grade_item_appeal+"</u> isn't valid (doesn't exist in gradebook) and hence  400 Bad Request status code returned !</h3>"
							+ " </FORM></h2></DIV></BODY></HTML>");
							
				}
				else
				{
					
				
				out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
						+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
						+ "\"400\" readonly> <br>"
						+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
						+ "\"NOT APPLICABLE\" readonly><b> <br>"
						+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
						+ "NOT APPLICABLE"
						+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
						+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Appeal couldn't be accepted as the Grade item <u>"+grade_item_appeal+"</u> hasn't even been graded by the Professor for Student with Student ID <u>"+student_id_appeal+"</u> and hence  400 Bad Request status code returned !</h3>"
						+ " </FORM></h2></DIV></BODY></HTML>");
						
				}
			}
			
		}
		else if (student_id_mygradebook!=null) //Read
		{
			System.out.println("Read My gradebook");
			 
			if(	studentService.studentExists(student_id_mygradebook) )
			{
			out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
						+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
						+ "\"200\" readonly> <br>"
						+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
						+ "\"NOT APPLICABLE\" readonly><b> <br>"
						+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
						+ "NOT APPLICABLE"
						+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
						
						+ "1. Link to access the resource for requested Student : <a href=\"/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/"+student_id_mygradebook+"\">Click me</a> <br><br>"
						+ "2. Action just performed : <h3 style=\"color:white; background-color:black;\">Student with Student ID <u>"+student_id_mygradebook+"</u> successfully requested his gradebook ! </h3>"
						+ " </FORM></h2></DIV></BODY></HTML>");
			}
			else
			{
				out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
						+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
						+ "\"404\" readonly> <br>"
						+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
						+ "\"NOT APPLICABLE\" readonly><b> <br>"
						+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
						+ "NOT APPLICABLE"
						+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
						+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Student with Student ID <u>"+student_id_mygradebook+"</u> doesn't exist and hence 404 Not Found status code returned !</h3>"
						+ " </FORM></h2></DIV></BODY></HTML>");
			}
				
		}
		else if (student_id_ins!=null) //Read instructor
		{
			System.out.println("Read FUll OR ONE ");
			 
			if(	studentService.studentExists(student_id_ins) || student_id_ins.equals("ALL") || student_id_ins.equals("All") || student_id_ins.equals("all") )
			{
				
				if (studentService.studentExists(student_id_ins))
				{
					out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
							+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
							+ "\"200\" readonly> <br>"
							+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
							+ "\"NOT APPLICABLE\" readonly><b> <br>"
							+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
							+ "NOT APPLICABLE"
							+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
							
							+ "1. Link to access the resource gradebook for the requested Student: <a href=\"/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/"+student_id_ins+"\">Click me</a> <br><br>"
							+ "2. Action just performed : <h3 style=\"color:white; background-color:black;\">Gradebook of Student ID <u>"+student_id_ins+"</u> successfully requested ! </h3>"
							+ " </FORM></h2></DIV></BODY></HTML>");
				}
				else
				{
					out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
							+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
							+ "\"200\" readonly> <br>"
							+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
							+ "\"NOT APPLICABLE\" readonly><b> <br>"
							+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
							+ "NOT APPLICABLE"
							+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
							
							+ "1. Link to access the resource gradebook for all students : <a href=\"/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/"+""+"\">Click me</a> <br><br>"
							+ "2. Action just performed : <h3 style=\"color:white; background-color:black;\">Gradebook for all students requested successfully ! </h3>"
							+ " </FORM></h2></DIV></BODY></HTML>");
				}
		
			}
			else
			{
				out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
						+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
						+ "\"404\" readonly> <br>"
						+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
						+ "\"NOT APPLICABLE\" readonly><b> <br>"
						+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
						+ "NOT APPLICABLE"
						+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
						+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Student with Student ID <u>"+student_id_ins+"</u> doesn't exist and hence 404 Not Found status code returned !</h3>"
						+ " </FORM></h2></DIV></BODY></HTML>");
			}
				
		}
		 
		else if (student_id_gremove !=null && grade_item_gremove !=null)  // Deleting a grade for a student
		{
			System.out.println("Delete Grade");
			
			if(studentService.grade_for_student_gradeItemExists(student_id_gremove,grade_item_gremove))
			{
				studentService.deleteGrade(student_id_gremove,grade_item_gremove);
				out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
				+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
				+ "\"204\" readonly> <br>"
				+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
				+ "\"NOT APPLICABLE\" readonly><b> <br>"
				+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
				+ "NOT APPLICABLE"
				+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
				+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Grade has been successfully deleted from the gradebook for student with Student ID " + student_id_gremove+" for Grade Item <u>"+ grade_item_gremove+"</u> </h3>"
				+ " </FORM></h2></DIV></BODY></HTML>");
			}
			else
			{
				if (!studentService.student_gradeItemExists(student_id_gremove,grade_item_gremove) )
				{
					out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
							+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
							+ "\"400\" readonly> <br>"
							+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
							+ "\"NOT APPLICABLE\" readonly><b> <br>"
							+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
							+ "NOT APPLICABLE"
							+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
							+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Grades couldn't be deleted as the provided combination of Student ID <u>"+student_id_gremove+"</u> and Gradeitem <u>"+grade_item_gremove+"</u> is invalid (doesn't exist) and hence 400 status code returned !</h3>"
							+ " </FORM></h2></DIV></BODY></HTML>");
				}
				else
				{
					out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
							+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
							+ "\"400\" readonly> <br>"
							+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
							+ "\"NOT APPLICABLE\" readonly><b> <br>"
							+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
							+ "NOT APPLICABLE"
							+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
							+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Grades couldn't be deleted as the professor hasn't even graded the student with Student ID <u>"+student_id_gremove+"</u> for Gradeitem <u>"+grade_item_gremove+"</u> and hence 400 status code returned !</h3>"
							+ " </FORM></h2></DIV></BODY></HTML>");
					
				}
				
				
				
						
			}

		}
		
		else  // for creation of student
		{
			Student student = new Student(student_id, student_name);
			
		
			if(	studentService.studentExists(student_id) )
			{
				out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
						+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
						+ "\"409\" readonly> <br>"
						+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
						+ "\"NOT APPLICABLE\" readonly><b> <br>"
						+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
						+ "NOT APPLICABLE"
						+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
						+ "Action just performed : <h3 style=\"color:white; background-color:black;\">Student with Student ID <u>"+student_id+"</u> already exists and cannot be recreated hence STATUS CONFLICT 409 status code returned !</h3>"
						+ " </FORM></h2></DIV></BODY></HTML>");
			}
			else
			{
					studentService.createStudent(student);
					out.println("<HTML><HEAD><TITLE>Response details</TITLE><style>input:focus { background-color: yellow;}</style></HEAD><BODY><div style=\"padding-left:5px;font-family: monospace;font-size: 18px;\"><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/index.html\">HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_instructor.html\">Instructor HOME</a><br><a href=\"/CRUD-GradeBook-rnihalan-Eclipse/CRUD_options_student.html\">Student HOME</a><br><br></div><div style=\"padding-left:70px;font-family: monospace;\"><h2><br><u>SERVER RESPONSE DETAILS</u> : <br><br>"
					+ "<FORM NAME=\"myform\"> 1. Response Code: <INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"4\" NAME=\"number1\" VALUE="
					+ "\"201\" readonly> <br>"
					+ "<br> 2. Media Type:&nbsp;&nbsp;&nbsp; <b><INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"20\" NAME=\"number1\" VALUE="
					+ "\"application/xml\" readonly><b> <br>"
					+ "<br> 3. Location: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE=\"text\" style=\"font-size:22px\" size=\"100\" NAME=\"number1\" VALUE=\""
					+ "http://localhost:8080/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/"+student_id+""
					+ "\" readonly> <br><br><br><br><u>ADDITIONAL DETAILS</u> : <br><br>"
					
					+ "1. Link to see the location of xml returned by server : <a href=\"/CRUD-GradeBook-rnihalan-Eclipse/rest/gradebook/"+student_id+"\">Click me</a> <br><br>"
					+ "2. Action just performed : <h3 style=\"color:white; background-color:black;\">Student <u>"+ student_name+"</u> has been successfully added with Student ID <u>"+student_id+"</u> into the gradebook ! </h3>"
					+ " </FORM></h2></DIV></BODY></HTML>");
			}
		
		} 
		out.flush();
		out.close(); 
	}

	@Path("{student}")
	public StudentResource getStudent(@PathParam("student") String id) {
		return new StudentResource(uriInfo, request, id);
	}
	
	@GET
	@Path("{student}/{grade_item}")
	@Produces(MediaType.TEXT_XML)
	public String getGradeItems(@PathParam("student") String student,@PathParam("grade_item") String grade_item) {
//		StudentResource obj=new StudentResource(uriInfo, request, student);
		
		if (studentService.student_gradeItemExists(student,grade_item) ) 
		{	
		String xml_temp="<student><student_id>"+student+"</student_id><student_name>"+studentService.getStudent(student).getStudent_name()+"</student_name><grade_item_details><appealed>";
		xml_temp+=studentService.get_student_gradeItem(student,grade_item).getAppealed();
		xml_temp+="</appealed><feedback>";
		xml_temp+=studentService.get_student_gradeItem(student,grade_item).getFeedback();
		xml_temp+="</feedback><grade>";
		xml_temp+=studentService.get_student_gradeItem(student,grade_item).getGrade();
		xml_temp+="</grade><grade_item>";
		xml_temp+=studentService.get_student_gradeItem(student,grade_item).getGrade_item();
		xml_temp+="</grade_item><weigtage>";
		xml_temp+=studentService.get_student_gradeItem(student,grade_item).getWeigtage();
		xml_temp+="</weigtage></grade_item_details></student>";
		//System.out.println(xml_temp);
		return xml_temp;
		}
		else 
		{
			return "<InvalidStudentIDGradeItem></InvalidStudentIDGradeItem>";
		}
	}  
	
}