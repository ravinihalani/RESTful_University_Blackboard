package com.javapapers.webservices.rest.jersey;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"student_id", "student_name","grade_item_details"})
public class Student {
	private String student_id;
	private String student_name;
    List<GradeItem> grade_item_details = new ArrayList<GradeItem>();
    //http://stackoverflow.com/questions/2707357/how-to-create-dynamic-two-dimensional-array-in-java

	public Student() {

	}

	public Student(String student_id, String student_name) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
	}

	public void setGrade_item_details(List<GradeItem> grade_item) {
		this.grade_item_details = grade_item;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String id) {
		this.student_id = id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String name) {
		this.student_name = name;
	}

	/**
     * @return the grade_item
     */
    public List<GradeItem> getGrade_item_details() {
        return grade_item_details;
    }

    /**
     * @param grade_item the grade_item to set
     */
    public void setGrade_item(String grade_item,String weigtage) {
    	GradeItem	g = new GradeItem();
    	g.setGrade_item(grade_item);
    	g.setGrade("Task not graded yet");
    	g.setWeigtage(weigtage);
    	g.setFeedback("No feedback");
    	g.setAppealed("Not-appealed");
    	this.grade_item_details.add(g);
    }
    
    public void deleteGrade_item(String grade_item_toremove) {
    	//System.out.println(grade_item_toremove);
    	
    	for (int i=0;i<grade_item_details.size();i++)
    	{
    		if(grade_item_details.get(i).getGrade_item().equals(grade_item_toremove))
    		{
    			grade_item_details.remove(i);
    			return;
    		}
    	}
    }
    
    public void updateGrade_item(String student_id_up,String grade_item_up,String weigtage_up,String grade_up,String feedback_up) {
    	
    	for (int i=0;i<grade_item_details.size();i++)
    	{
    		if(grade_item_details.get(i).getGrade_item().equals(grade_item_up))
    		{
    			GradeItem	g1 = new GradeItem();
    	    	g1.setGrade_item(grade_item_up);
    	    	g1.setGrade(grade_up);
    	    	g1.setWeigtage(weigtage_up);
    	    	g1.setFeedback(feedback_up);
    	    	g1.setAppealed("Not-appealed");
    	    	
    			grade_item_details.set(i, g1);
    		//	System.out.println("Updating "+ grade_item_up + grade_up + weigtage_up + feedback_up + "Not-appealed");
    			return;
    		}
    	}
    }
    
    public void appealGradeItem(String student_id_appeal,String grade_item_appeal, Student student) {
    	
    	for (int i=0;i<grade_item_details.size();i++)
    	{
    		if(grade_item_details.get(i).getGrade_item().equals(grade_item_appeal))
    		{
    			GradeItem	g1 = new GradeItem();
    	    	g1.setGrade_item(grade_item_appeal);
    	    	g1.setGrade(grade_item_details.get(i).getGrade());
    	    	g1.setWeigtage(grade_item_details.get(i).getWeigtage());
    	    	g1.setFeedback(grade_item_details.get(i).getFeedback());
    	    	g1.setAppealed("Appealed");
    	    	
    			grade_item_details.set(i, g1);
    		//	System.out.println("Updating "+ grade_item_up + grade_up + weigtage_up + feedback_up + "Not-appealed");
    			return;
    		}
    	}
    }
   

}