/**
 * 
 */
package com.iet.ExamCell.Service;

/**
 * @author admin 
 *
 */
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iet.ExamCell.DAO.HomeDAO;
import com.iet.ExamCell.Model.ComboDO;
import com.iet.ExamCell.Model.Login;
import com.iet.ExamCell.Model.NominalRole;
import com.iet.ExamCell.Model.AverageMarks;

@Service
public class HomeServiceImpl implements HomeService {

	  @Autowired
	  public HomeDAO homeDao;

	  public void register(NominalRole student) {
	    try {
			homeDao.register(student);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  public void register1(AverageMarks marks) {
		    try {
				homeDao.register1(marks);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }

	  public Login validateUser(Login login) {
	    return homeDao.validateUser(login);
	  } 
	  
	  public void saveNominalRole(NominalRole student) {
		    try {
				homeDao.register(student);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	  public void saveAverageMarks(AverageMarks marks) {
		    try {
				homeDao.register1(marks);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	  
	  public NominalRole getNominalRoleById(int regno) {
		    return homeDao.getNominalRoleById(regno);
		  }
	  public AverageMarks getAverageMarksById(int regno) {
		    return homeDao.getAverageMarksById(regno);
		  }
	  
	  public List<NominalRole> getAllNominalRoles(){
		  return homeDao.getAllNominalRoles();
	  }
	  public List<AverageMarks> getAllAverageMarks(){
		  return homeDao.getAllAverageMarks();
	  }
	  public int update(NominalRole p){
		  return homeDao.update(p);
	  }
	  public int update1(AverageMarks p){
		  return homeDao.update1(p);
	  }

	  // to load Department combobox values
	  

		  public List<ComboDO> getAllDept(){
			  return homeDao.getAllDept();
		  
		  }
		  public List<ComboDO> getAllDegree(){
			  return homeDao.getAllDegree();
		  }

		  public List<ComboDO> getAllYear(){
			  return homeDao.getAllYear();
		  }

	      public List<ComboDO> getAllSection(){
				  return homeDao.getAllSection();	
				  }

        public List<ComboDO> getAllSemester(){
	              return homeDao.getAllSemester();
        }
}