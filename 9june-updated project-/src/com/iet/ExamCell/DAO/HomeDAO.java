/**
 * 
 */
package com.iet.ExamCell.DAO;

/**
 * @author admin
 *
 */
import java.text.ParseException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.iet.ExamCell.Model.ComboDO;
import com.iet.ExamCell.Model.Login;
import com.iet.ExamCell.Model.NominalRole;

public interface HomeDAO {
	void setTemplate(JdbcTemplate template);
	Login validateUser(Login login);
	void register(NominalRole user) throws ParseException;
	NominalRole showStudents(NominalRole student);
	int update(NominalRole p);
	int delete(int id);
	NominalRole getNominalRoleById(int regno);
	List<NominalRole> getAllNominalRoles();
	// to load Department combobox values
	List<ComboDO> getAllDegree();
	List<ComboDO> getAllDept();
	List<ComboDO> getAllYear();
	List<ComboDO> getAllSection();
	
	
}
