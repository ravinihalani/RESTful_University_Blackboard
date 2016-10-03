package com.javapapers.webservices.rest.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class StudentResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String student_id;

	StudentService studentService;

	public StudentResource(UriInfo uriInfo, Request request, String student_id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.student_id = student_id;
		studentService = new StudentService();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Student getStudent() {
		Student student = studentService.getStudent(student_id);
		return student;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public Student getStudentAsHtml() {
		Student student = studentService.getStudent(student_id);
		return student;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response putAnimal(JAXBElement<Student> studentElement) {
		Student student = studentElement.getValue();
		Response response;
		if (studentService.getStudents().containsKey(student.getStudent_id())) {
			response = Response.noContent().build();
		} else {
			response = Response.created(uriInfo.getAbsolutePath()).build();
		}
		studentService.createStudent(student);
		return response;
	}

	@DELETE
	public void deleteAnimal() {
		studentService.deleteStudent(student_id);
	}

}