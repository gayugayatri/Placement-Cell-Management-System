package com.iet.ExamCell.Model;

public class AverageMarks {
	private int nominalRoleId;
	private String regno;
	private int semester;
	private int mark;
	
	public AverageMarks() {
		// TODO Auto-generated constructor stub
	}
	
	public AverageMarks(String regno, int semester, int mark ){
		this.regno = regno;
		this.semester = semester;
		this.mark = mark;
		
	}

	public int getNominalRoleId() {
		return nominalRoleId;
	}

	public void setNominalRoleId(int nominalRoleId) {
		this.nominalRoleId = nominalRoleId;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	

}
