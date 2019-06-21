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

import com.iet.ExamCell.Model.AverageMarks;
import com.iet.ExamCell.Model.ComboDO;
import com.iet.ExamCell.Model.Login;
import com.iet.ExamCell.Model.NominalRole;

public interface HomeDAO {
	void setTemplate(JdbcTemplate template);
	Login validateUser(Login login);
	void register(NominalRole user) throws ParseException;
	void register1(AverageMarks user) throws ParseException;
	NominalRole showStudents(NominalRole student);
	AverageMarks showMarks(AverageMarks marks);
	int update(NominalRole p);
	int update1(AverageMarks p);
	int delete(int id);
	int delete1(int id);
    NominalRole getNominalRoleById(int regno);
    AverageMarks getAverageMarksById(int regno);
	List<NominalRole> getAllNominalRoles();
	List<AverageMarks> getAllAverageMarks();
	// to load Department combobox values
	List<ComboDO> getAllDegree();
	List<ComboDO> getAllDept();
	List<ComboDO> getAllYear();
	List<ComboDO> getAllSection();
	List<ComboDO> getAllSemester();
	
	
}
