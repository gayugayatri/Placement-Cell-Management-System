package com.iet.ExamCell.Model;

import java.io.Serializable;

public class AverageMarks implements Serializable {

	private int semmarksId;
	private int regno;
	private int avgmarkId;
	private int nominalRoleId;
	private int sem1Mark;
	private int sem2Mark;
	private int sem3Mark;
	private int sem4Mark;
	private int sem5Mark;
	private int sem6Mark;
	private int sem7Mark;
	private int sem8Mark;
	private int sem9Mark;
	private int sem10Mark;
	private int avgmark;
	private int hisofarrear;
	private int currentarrear;
	
	
	public AverageMarks() {
		// TODO Auto-generated constructor stub
	}


	public AverageMarks(int semmarksId, int regno, int avgmarkId,
			int nominalRoleId, int sem1Mark, int sem2Mark, int sem3Mark,
			int sem4Mark, int sem5Mark, int sem6Mark, int sem7Mark,
			int sem8Mark, int sem9Mark, int sem10Mark, int avgmark,
			int hisofarrear, int currentarrear) {
		super();
		this.semmarksId = semmarksId;
		this.regno = regno;
		this.avgmarkId = avgmarkId;
		this.nominalRoleId = nominalRoleId;
		this.sem1Mark = sem1Mark;
		this.sem2Mark = sem2Mark;
		this.sem3Mark = sem3Mark;
		this.sem4Mark = sem4Mark;
		this.sem5Mark = sem5Mark;
		this.sem6Mark = sem6Mark;
		this.sem7Mark = sem7Mark;
		this.sem8Mark = sem8Mark;
		this.sem9Mark = sem9Mark;
		this.sem10Mark = sem10Mark;
		this.avgmark = avgmark;
		this.hisofarrear = hisofarrear;
		this.currentarrear = currentarrear;
	}


	public int getSemmarksId() {
		return semmarksId;
	}


	public void setSemmarksId(int semmarksId) {
		this.semmarksId = semmarksId;
	}


	public int getRegno() {
		return regno;
	}


	public void setRegno(int regno) {
		this.regno = regno;
	}


	public int getAvgmarkId() {
		return avgmarkId;
	}


	public void setAvgmarkId(int avgmarkId) {
		this.avgmarkId = avgmarkId;
	}


	public int getNominalRoleId() {
		return nominalRoleId;
	}


	public void setNominalRoleId(int nominalRoleId) {
		this.nominalRoleId = nominalRoleId;
	}


	public int getSem1Mark() {
		return sem1Mark;
	}


	public void setSem1Mark(int sem1Mark) {
		this.sem1Mark = sem1Mark;
	}


	public int getSem2Mark() {
		return sem2Mark;
	}


	public void setSem2Mark(int sem2Mark) {
		this.sem2Mark = sem2Mark;
	}


	public int getSem3Mark() {
		return sem3Mark;
	}


	public void setSem3Mark(int sem3Mark) {
		this.sem3Mark = sem3Mark;
	}


	public int getSem4Mark() {
		return sem4Mark;
	}


	public void setSem4Mark(int sem4Mark) {
		this.sem4Mark = sem4Mark;
	}


	public int getSem5Mark() {
		return sem5Mark;
	}


	public void setSem5Mark(int sem5Mark) {
		this.sem5Mark = sem5Mark;
	}


	public int getSem6Mark() {
		return sem6Mark;
	}


	public void setSem6Mark(int sem6Mark) {
		this.sem6Mark = sem6Mark;
	}


	public int getSem7Mark() {
		return sem7Mark;
	}


	public void setSem7Mark(int sem7Mark) {
		this.sem7Mark = sem7Mark;
	}


	public int getSem8Mark() {
		return sem8Mark;
	}


	public void setSem8Mark(int sem8Mark) {
		this.sem8Mark = sem8Mark;
	}


	public int getSem9Mark() {
		return sem9Mark;
	}


	public void setSem9Mark(int sem9Mark) {
		this.sem9Mark = sem9Mark;
	}


	public int getSem10Mark() {
		return sem10Mark;
	}


	public void setSem10Mark(int sem10Mark) {
		this.sem10Mark = sem10Mark;
	}


	public int getAvgmark() {
		return avgmark;
	}


	public void setAvgmark(int avgmark) {
		this.avgmark = avgmark;
	}


	public int getHisofarrear() {
		return hisofarrear;
	}


	public void setHisofarrear(int hisofarrear) {
		this.hisofarrear = hisofarrear;
	}


	public int getCurrentarrear() {
		return currentarrear;
	}


	public void setCurrentarrear(int currentarrear) {
		this.currentarrear = currentarrear;
	}

	
}