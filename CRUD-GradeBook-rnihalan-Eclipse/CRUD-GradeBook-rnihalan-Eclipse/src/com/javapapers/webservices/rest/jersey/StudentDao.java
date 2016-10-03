package com.javapapers.webservices.rest.jersey;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public enum StudentDao {
	instance;

	private Map<String, Student> gradebook = new HashMap<String, Student>();

	private StudentDao() {

		Student student = new Student("1", "Bruce Wayne" );
		gradebook.put("1", student);
		student = new Student("2", "David Letterman");
		gradebook.put("2", student); 
	}

	public Map<String, Student> getStudents() {
		return gradebook;
	}
	
	public void addGradeItem(String add_grade_item_for_all, String weightage_for_all)
	{
	for (Entry<String, Student> entry : gradebook.entrySet())
	{
	entry.getValue().setGrade_item(add_grade_item_for_all,weightage_for_all);
	}	
		// http://stackoverflow.com/questions/46898/how-to-efficiently-iterate-over-each-entry-in-a-map
	}
	public void deleteGradeItem(String grade_item_toremove)
	{
	for (Entry<String, Student> entry : gradebook.entrySet())
	{
	entry.getValue().deleteGrade_item(grade_item_toremove);
	}	
		// http://stackoverflow.com/questions/46898/how-to-efficiently-iterate-over-each-entry-in-a-map
	}
	
	
	public void deleteGrade(String student_id_gremove,String grade_item_gremove)
	{
		for (Entry<String, Student> entry : gradebook.entrySet())
		{
			if (entry.getValue().getStudent_id().equals(student_id_gremove))
			{
			for (int i=0;i<entry.getValue().getGrade_item_details().size();i++)
				{
				if (entry.getValue().getGrade_item_details().get(i).getGrade_item().equals(grade_item_gremove))
				{
					entry.getValue().getGrade_item_details().get(i).setGrade("Task not graded yet");
				return ;
				}
				}
			}
		}
		return ;
		// http://stackoverflow.com/questions/46898/how-to-efficiently-iterate-over-each-entry-in-a-map
	}
	
	
	
	
	
	
	public void updateGradeItem(String student_id_up,String grade_item_up,String weigtage_up,String grade_up,String feedback_up)
	{
	for (Entry<String, Student> entry : gradebook.entrySet())
	{
		if (entry.getValue().getStudent_id().equals(student_id_up))
		{
			entry.getValue().updateGrade_item(student_id_up,grade_item_up,weigtage_up,grade_up,feedback_up);
			return;
		}
	
	}	
		// http://stackoverflow.com/questions/46898/how-to-efficiently-iterate-over-each-entry-in-a-map
	}
	
	public void appealGradeItem(String student_id_appeal,String grade_item_appeal)
	{
	for (Entry<String, Student> entry : gradebook.entrySet())
	{
		if (entry.getValue().getStudent_id().equals(student_id_appeal))
		{
			entry.getValue().appealGradeItem(student_id_appeal,grade_item_appeal,entry.getValue());
			return;
		}
	
	}	
		// http://stackoverflow.com/questions/46898/how-to-efficiently-iterate-over-each-entry-in-a-map
	}
	
	
	public boolean studentExists(String student_id_mygradebook)
	{
	for (Entry<String, Student> entry : gradebook.entrySet())
	{
		if (entry.getValue().getStudent_id().equals(student_id_mygradebook))
		{
		
			return true;
		}
	
	}
	return false;
		// http://stackoverflow.com/questions/46898/how-to-efficiently-iterate-over-each-entry-in-a-map
	}

	
	public boolean gradeItemExists(String add_grade_item_for_all)
	{
	for (Entry<String, Student> entry : gradebook.entrySet())
	{
		for (int i=0;i<entry.getValue().getGrade_item_details().size();i++)
	{
		
			if (entry.getValue().getGrade_item_details().get(i).getGrade_item().equals(add_grade_item_for_all))
			{
			
				return true;
			}
	}
	}
	return false;
		// http://stackoverflow.com/questions/46898/how-to-efficiently-iterate-over-each-entry-in-a-map
	}
	
	
	
	public boolean student_gradeItemExists(String student_id_up,String grade_item_up)
	{
	for (Entry<String, Student> entry : gradebook.entrySet())
	{
		if (entry.getValue().getStudent_id().equals(student_id_up))
		{
		for (int i=0;i<entry.getValue().getGrade_item_details().size();i++)
			{
			if (entry.getValue().getGrade_item_details().get(i).getGrade_item().equals(grade_item_up))
			{
			return true;
			}
			}
		}
	}
	return false;
		// http://stackoverflow.com/questions/46898/how-to-efficiently-iterate-over-each-entry-in-a-map
	}
	
	
	
	public boolean grade_for_student_gradeItemExists(String student_id_up,String grade_item_up)
	{
	for (Entry<String, Student> entry : gradebook.entrySet())
	{
		if (entry.getValue().getStudent_id().equals(student_id_up))
		{
		for (int i=0;i<entry.getValue().getGrade_item_details().size();i++)
			{
			if (entry.getValue().getGrade_item_details().get(i).getGrade_item().equals(grade_item_up) && !entry.getValue().getGrade_item_details().get(i).getGrade().equals("Task not graded yet"))
			{
			return true;
			}
			}
		}
	}
	return false;
		// http://stackoverflow.com/questions/46898/how-to-efficiently-iterate-over-each-entry-in-a-map
	}
	
	public  GradeItem get_student_gradeItem(String student_id_up,String grade_item_up)
	{
	for (Entry<String, Student> entry : gradebook.entrySet())
	{
		if (entry.getValue().getStudent_id().equals(student_id_up))
		{
		for (int i=0;i<entry.getValue().getGrade_item_details().size();i++)
			{
			if (entry.getValue().getGrade_item_details().get(i).getGrade_item().equals(grade_item_up))
			{
			return entry.getValue().getGrade_item_details().get(i);
			}
			}
		}
	}
	
	return null;
		// http://stackoverflow.com/questions/46898/how-to-efficiently-iterate-over-each-entry-in-a-map
	}

	
	

}