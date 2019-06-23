package com.iet.ExamCell.Model;
import java.util.Date;
import java.io.Serializable;

public class CompanyDetails implements Serializable{
      private int criteriaId;
      private int companyId;
      private  Date dop;
      private int percentage;
      private int historyofarrears;
      private int currentarrears;
      
      

public CompanyDetails() {
	// TODO Auto-generated constructor stub
}
public CompanyDetails(int companyId, Date dop,
		int percentage, int historyofarrears, int currentarrears) {
	
	this.companyId = companyId;
	this.dop = dop;
	this.percentage = percentage;
	this.historyofarrears = historyofarrears;
	this.currentarrears = currentarrears;
	
}
public int getCriteriaId() {
	return criteriaId;
}
public void setCriteriaId(int criteriaId) {
	this.criteriaId = criteriaId;
}
public int getCompanyId() {
	return companyId;
}
public void setCompanyId(int companyId) {
	this.companyId = companyId;
}
public Date getDop() {
	return dop;
}
public void setDop(Date dop) {
	this.dop = dop;
}
public int getPercentage() {
	return percentage;
}
public void setPercentage(int percentage) {
	this.percentage = percentage;
}
public int getHistoryofarrears() {
	return historyofarrears;
}
public void setHistoryofarrears(int historyofarrears) {
	this.historyofarrears = historyofarrears;
}
public int getCurrentarrears() {
	return currentarrears;
}
public void setCurrentarrears(int currentarrears) {
	this.currentarrears = currentarrears;
}

}
