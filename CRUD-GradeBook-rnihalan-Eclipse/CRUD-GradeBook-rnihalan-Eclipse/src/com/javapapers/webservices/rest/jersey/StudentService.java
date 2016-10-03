package com.javapapers.webservices.rest.jersey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class StudentService {

	StudentDao studentDao;

	public StudentService() {
		studentDao = StudentDao.instance;
	}

	public void createStudent(Student student) {
		studentDao.getStudents().put(student.getStudent_id(), student);
	}

	public Student getStudent(String student_id) {
		return studentDao.getStudents().get(student_id);
	}

	public Map<String, Student> getStudents() {
		return studentDao.getStudents();
	}

	public List<Student> getStudentAsList() {
		List<Student> studentList = new ArrayList<Student>();
		studentList.addAll(studentDao.getStudents().values());
		
//		System.out.println("RAVI--->" + studentDao.getStudents().get("1").getGrade_item_combo().get(0)[0] + "/1." + studentDao.getStudents().get("1").getGrade_item_combo().get(0)[1] + "/2." + studentDao.getStudents().get("1").getGrade_item_combo().get(0)[2] + "/3." + studentDao.getStudents().get("1").getGrade_item_combo().get(0)[3] );
		
/*	yo:	for (Entry<String, Student> entry : studentDao.getStudents().entrySet())
		{
		System.out.println("RAVI--->" + entry.getValue().getGrade_item_combo().get(0)[0] + "/1." + entry.getValue().getGrade_item_combo().get(0)[1] + "/2." + entry.getValue().getGrade_item_combo().get(0)[2] + "/3." + entry.getValue().getGrade_item_combo().get(0)[3] );
		break yo;
		} */	
				 
		
		return studentList;
	}

	public int getStudentsCount() {
		return studentDao.getStudents().size();
	}

	public void deleteStudent(String student_id) {
		studentDao.getStudents().remove(student_id);
		System.out.println("Delete"+student_id);
	}
	
	public void addGradeItem (String add_grade_item_for_all, String weightage_for_all)
	{
		studentDao.addGradeItem(add_grade_item_for_all,weightage_for_all);
	}	
	
	public void deleteGradeItem (String grade_item_toremove)
	{
		studentDao.deleteGradeItem(grade_item_toremove);
	}
	
	public void deleteGrade (String student_id_gremove,String grade_item_gremove)
	{
		studentDao.deleteGrade(student_id_gremove,grade_item_gremove);
	}
	
	
	public void updateGradeItem (String student_id_up,String grade_item_up,String weigtage_up,String grade_up,String feedback_up)
	{
		studentDao.updateGradeItem(student_id_up,grade_item_up,weigtage_up,grade_up,feedback_up);
	}	
	
	
	public void appealGradeItem (String student_id_appeal,String grade_item_appeal)
	{
		studentDao.appealGradeItem(student_id_appeal,grade_item_appeal);
	}	
	
	public boolean studentExists (String student_id_mygradebook)
	{
		return studentDao.studentExists(student_id_mygradebook);
	}	
	
	public boolean gradeItemExists (String add_grade_item_for_all)
	{
		return studentDao.gradeItemExists(add_grade_item_for_all);
	}
	
	
	public boolean student_gradeItemExists (String student_id_up,String grade_item_up)
	{
		return studentDao.student_gradeItemExists(student_id_up,grade_item_up);
	}
	
	public boolean grade_for_student_gradeItemExists (String student_id_up,String grade_item_up)
	{
		return studentDao.grade_for_student_gradeItemExists(student_id_up,grade_item_up);
	}
	
	public GradeItem get_student_gradeItem (String student,String grade_item)
	{
		return studentDao.get_student_gradeItem(student, grade_item);
	}	
	
}