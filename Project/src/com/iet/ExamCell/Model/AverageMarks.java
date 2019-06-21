package com.iet.ExamCell.Model;

public class AverageMarks {

	private int semmarksId;
	private String regno;
	private int semester;
	private int mark;
	private int avgmarks;
	private int hisofarrears;
	private int currentarrears;
	
	
	public AverageMarks() {
		// TODO Auto-generated constructor stub
	}
	
	public AverageMarks(int semmarksId, String regno, int semester,
			int mark, int avgmarks, int hisofarrears, int currentarrears ) {
		
		this.semmarksId = semmarksId;
		this.regno =regno;
		this.semester = semester;
		this.mark = mark;
		this.avgmarks = avgmarks;
		this.hisofarrears = hisofarrears;
		this.currentarrears = currentarrears;
	}

	public int getSemmarksId() {
		return semmarksId;
	}

	public void setSemmarksId(int semmarksId) {
		this.semmarksId = semmarksId;
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

	public int getAvgmarks() {
		return avgmarks;
	}

	public void setAvgmarks(int avgmarks) {
		this.avgmarks = avgmarks;
	}

	public int getHisofarrears() {
		return hisofarrears;
	}

	public void setHisofarrears(int hisofarrears) {
		this.hisofarrears = hisofarrears;
	}

	public int getCurrentarrears() {
		return currentarrears;
	}

	public void setCurrentarrears(int currentarrears) {
		this.currentarrears = currentarrears;
	}

}
