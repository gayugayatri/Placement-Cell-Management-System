/**
 * 
 */
package com.iet.ExamCell.Service;

/**
 * @author admin
 *
 */
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iet.ExamCell.Model.AverageMarks;
import com.iet.ExamCell.Model.ComboDO;
import com.iet.ExamCell.Model.CompanyDetails;
import com.iet.ExamCell.Model.Login;
import com.iet.ExamCell.Model.NominalRole;

@Service
@Transactional
public interface HomeService {

	  void register(NominalRole student);
	  void register1(AverageMarks mark);
	  void registerCompanyDetails(CompanyDetails company);
	  Login validateUser(Login login);
	  
	  void saveNominalRole(NominalRole student);
	  void saveAverageMarks(AverageMarks mark);
	  void saveCompanyDetails(CompanyDetails company);
	  NominalRole getNominalRoleById(int regno);
	  AverageMarks getAverageMarksById(int regno);
	  CompanyDetails getCompanyDetailsById(int companyId);
	  List<NominalRole> getAllNominalRoles();
	  List<AverageMarks> getAllAverageMarks();
	  List<CompanyDetails> getAllCompanyDetails();
	  int update(NominalRole p);
	  int update1(AverageMarks p);
	  int updateCompanyDetails(CompanyDetails p);
	  List<ComboDO> getAllDegree(int deptId);
	  List<ComboDO> getAllDept();
	  List<ComboDO> getAllYear();
	  List<ComboDO> getAllSection();
	  List<ComboDO> getAllRegno();
	  //List<ComboDO> getAllSemester();
	  }
