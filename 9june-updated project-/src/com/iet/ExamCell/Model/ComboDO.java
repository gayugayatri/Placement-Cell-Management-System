/**
 * 
 */
package com.iet.ExamCell.Model;

/**
 * @author opensource
 *
 */
public class ComboDO {

	private int id;
	private String value;
	
	/**
	 * @param id
	 * @param value
	 */
	public ComboDO(int id, String value) {
		this.id = id;
		this.value = value;
	}
	
	public ComboDO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	
}

