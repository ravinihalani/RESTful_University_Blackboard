package com.javapapers.webservices.rest.jersey;

public class GradeItem {
	String student_id;
	String grade_item;
	String weigtage;
	String grade;
	String feedback;
	String appealed;
	public String getAppealed() {
		return appealed;
	}
	public void setAppealed(String appealed) {
		this.appealed = appealed;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getGrade_item() {
		return grade_item;
	}
	public void setGrade_item(String grade_item) {
		this.grade_item = grade_item;
	}
	public String getWeigtage() {
		return weigtage;
	}
	public void setWeigtage(String weigtage) {
		this.weigtage = weigtage;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	

}
