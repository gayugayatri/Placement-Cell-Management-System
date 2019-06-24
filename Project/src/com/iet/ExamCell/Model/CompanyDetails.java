package com.iet.ExamCell.Model;
import java.util.Date;
import java.io.Serializable;

public class CompanyDetails implements Serializable{
      
	  private int companyId;
      private String companyName;
      private  Date dop;
      private int percentage;
      private String hisofarrear;
      private String currentarrear;
      
      

public CompanyDetails() {
	// TODO Auto-generated constructor stub
}



public CompanyDetails(int companyId, String companyName, Date dop, int percentage,
		String hisofarrear, String currentarrear) {
	
	this.companyId = companyId;
	this.companyName = companyName;
	this.dop = dop;
	this.percentage = percentage;
	this.hisofarrear = hisofarrear;
	this.currentarrear = currentarrear;
}



public int getCompanyId() {
	return companyId;
}



public void setCompanyId(int companyId) {
	this.companyId = companyId;
}



public String getCompanyName() {
	return companyName;
}



public void setCompanyName(String string) {
	this.companyName = string;
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



public String getHisofarrear() {
	return hisofarrear;
}



public void setHisofarrear(String hisofarrear) {
	this.hisofarrear = hisofarrear;
}



public String getCurrentarrear() {
	return currentarrear;
}



public void setCurrentarrear(String currentarrear) {
	this.currentarrear = currentarrear;
}


}
