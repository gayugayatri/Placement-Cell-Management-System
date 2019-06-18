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

	public int getNominalRoleId() {
		return nominalRoleId;
	}

	public void setNominalRoleId(int nominalRoleId) {
		this.nominalRoleId = nominalRoleId;
	}

	private int nominalRoleId;
	private String regno;	
	private String name;
	private int degree;
	private int dept;
	private int section;
	private int year;
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
	public NominalRole(String regno, String name,
			int degree, int dept, int section, int year, Date yoj, String email ) {
		
		this.regno = regno;
		this.name = name;
		this.degree = degree;
		this.dept = dept;
		this.section = section;
		this.year=year;
		this.yoj = yoj;
		this.email= email;
	}
	
	/**
	 * 
	 */
	public NominalRole() {
		// TODO Auto-generated constructor stub
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String i) {
		this.regno = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the yoj
	 */
	public Date getYoj(){
		return yoj;
	}
	

	/**
	 * @param yoj the yoj to set
	 */
	 
	public void setYoj(Date yoj) {
		this.yoj = yoj;
	}
	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

