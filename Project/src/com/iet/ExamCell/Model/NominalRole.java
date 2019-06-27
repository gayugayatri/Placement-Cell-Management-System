/**

 * 
 */
package com.iet.ExamCell.Model;

/**
 * @author admin
 *
 */
import java.io.Serializable;
import java.util.Date;

public class NominalRole implements Serializable{ 

	
	private int nominalRoleId;
	private String regno;	
	private String name;
	private int degree;
	private String degreeName;
	private int dept;
	private String deptName;
	private int section;
	private String sectionName;
	private int year;
	private int yearName;
	private Date yoj; 
	private String email;
		

	/**
	 * @param studentId
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param address
	 * @param phone
	 */
	public NominalRole()
	{
	}
	

	public NominalRole(int nominalRoleId, String regno, String name,
			int degree, String degreeName, int dept, String deptName,
			int section, String sectionName, int year, int yearName, Date yoj,
			String email) {
		super();
		this.nominalRoleId = nominalRoleId;
		this.regno = regno;
		this.name = name;
		this.degree = degree;
		this.degreeName = degreeName;
		this.dept = dept;
		this.deptName = deptName;
		this.section = section;
		this.sectionName = sectionName;
		this.year = year;
		this.yearName = yearName;
		this.yoj = yoj;
		this.email = email;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getDegree() {
		return degree;
	}


	public void setDegree(int degree) {
		this.degree = degree;
	}


	public String getDegreeName() {
		return degreeName;
	}


	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}


	public int getDept() {
		return dept;
	}


	public void setDept(int dept) {
		this.dept = dept;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public int getSection() {
		return section;
	}


	public void setSection(int section) {
		this.section = section;
	}


	public String getSectionName() {
		return sectionName;
	}


	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getYearName() {
		return yearName;
	}


	public void setYearName(int yearName) {
		this.yearName = yearName;
	}


	public Date getYoj() {
		return yoj;
	}


	public void setYoj(Date yoj) {
		this.yoj = yoj;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


}

