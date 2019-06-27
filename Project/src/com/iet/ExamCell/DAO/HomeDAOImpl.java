
/**
 * 
 */
package com.iet.ExamCell.DAO;

/**
 * @author admin
 *
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Date;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iet.ExamCell.Model.AverageMarks;
import com.iet.ExamCell.Model.ComboDO;
import com.iet.ExamCell.Model.CompanyDetails;
import com.iet.ExamCell.Model.Login;
import com.iet.ExamCell.Model.NominalRole;

@Repository
@Transactional
public class HomeDAOImpl implements HomeDAO {

	  @Autowired
	  DataSource datasource;

	  @Autowired
	  JdbcTemplate jdbcTemplate;

	  public void setTemplate(JdbcTemplate template) {  
		    this.jdbcTemplate = template;  
	  }  
	  
	  public Login validateUser(Login login) {

		  String sql = "SELECT count(*) from TBL_MST_LOGIN_ACCESS WHERE vch_username = ? and VCH_PASSWORD = ?";
			int count = jdbcTemplate.queryForObject(sql, Integer.class, login.getUsername(), login.getPassword());
			if(count == 0) {
	    		        return null;
			} else {
				return login;
			}
	  }

	  public void register(NominalRole student){

	    String sql = "insert into tbl_mst_nominal_role (vch_reg_number, vch_name, dtt_year_of_joining, num_year_id, num_degree_id, num_dept_id, num_section_id, vch_email_id) "
	    		+ "values(?,?,?,?,?,?,?,?)";
		//String sql = "insert into tbl_mst_nominal_role (vch_reg_number, vch_name,num_degree_id, num_dept_id, num_year_id, num_section_id, vch_email_id) values(?,?,?,?,?,?,?)";
	    //jdbcTemplate.update(sql, new Object[] { student.getRegno(),student.getName(),student.getDegree(),student.getDept(),student.getYear(),student.getSection() student.getEmail()});
	  //}
	    /*if(student.getYoj() != null)
	    {
	    DateFormat formatDate1 = new SimpleDateFormat("dd/MM/yyyy");
	    Date formatedDate1 = null;
	    try {
	    formatedDate1 = formatDate1.parse(student.getYoj().toString());
	    } catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    }*/
	    
	    DateFormat dateFormat= new SimpleDateFormat("dd-MMM-yyy");

	    /*try{
	        Date formattedDate;*/
			try {
				student.setYoj(dateFormat.parse(dateFormat.format(student.getYoj())));
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    /*}catch(ParseException parseEx){
	        parseEx.printStackTrace();
	    }*/
	    
	    jdbcTemplate.update(sql, new Object[] { student.getRegno(),
	    	student.getName(), student.getYoj(), student.getDegree(), student.getDept(), student.getSection(), student.getYear(), student.getEmail()});
	  }

	  public void register1(AverageMarks marks){

		  String sql= "insert into tbl_mst_avg_marks ( num_nominal_role_id, num_avg_marks, num_his_of_arrears, num_cur_arrears)"+ "values(?,?,?,?)";	
		    
		  jdbcTemplate.update(sql, new Object[] {marks.getNominalRoleId(), marks.getAvgmark(),  marks.getHisofarrear(), marks.getCurrentarrear()});
			      
		  sql = "SELECT max(num_avg_marks_id) from tbl_mst_avg_marks";
		  int num_avg_marks_id = jdbcTemplate.queryForObject(sql, Integer.class);
			
		  sql = "insert into tbl_mst_sem_marks (num_avg_marks_id, num_sem1_mark, num_sem2_mark, num_sem3_mark, num_sem4_mark, num_sem5_mark, num_sem6_mark, num_sem7_mark, num_sem8_mark, num_sem9_mark, num_sem10_mark) "
		    		+ "values(?,?,?,?,?,?,?,?,?,?,?)";
           	    
		  jdbcTemplate.update(sql, new Object[] { num_avg_marks_id,
		    	marks.getSem1Mark(),marks.getSem2Mark(),marks.getSem3Mark(),marks.getSem4Mark(),marks.getSem5Mark(),marks.getSem6Mark(),marks.getSem7Mark(),marks.getSem8Mark(),marks.getSem9Mark(),marks.getSem10Mark()});
		  
		    
		
	  }
	  public void registerCompanyDetails(CompanyDetails company){

		    String sql = "insert into tbl_mst_companydetails (vch_company_name, dtt_dop, num_percentage, vch_his_of_arrear, vch_cur_arrear) "
		    		+ "values(?,?,?,?,?)";
		    
		    jdbcTemplate.update(sql, new Object[] {company.getCompanyName(),
		    		company.getDop(), company.getPercentage(), company.getHisofarrear(), company.getCurrentarrear()});
			  }
	  

	  public NominalRole showStudents(NominalRole student) {

	    String sql = "select num_nominal_role_id,"+ 
	    		" vch_reg_number, vch_name,"+ 
	    		" dtt_year_of_joining,"+
	    		" tbl_mst_year.num_year_id, tbl_mst_year.num_year,"+
	    		" tbl_mst_degree.num_degree_id, tbl_mst_degree.vch_degree_name,"+
	    		" tbl_mst_dept.num_dept_id, tbl_mst_dept.vch_dept_name,"+
	    		" tbl_mst_section.num_section_id, tbl_mst_section.vch_section,"+ 
	    		" vch_email_id"+ 
	    		" from tbl_mst_nominal_role, tbl_mst_year, tbl_mst_degree, tbl_mst_dept, tbl_mst_section"+
	    		" where tbl_mst_nominal_role.num_year_id = tbl_mst_year.num_year_id"+
	    		" AND tbl_mst_nominal_role.num_degree_id = tbl_mst_degree.num_degree_id"+
	    		" AND tbl_mst_nominal_role.num_dept_id = tbl_mst_dept.num_dept_id"+
	    		" AND tbl_mst_nominal_role.num_section_id = tbl_mst_section.num_section_id"+
	    		" order by num_nominal_role_id";
	    List<NominalRole> students = jdbcTemplate.query(sql, new NominalRoleMapper());

	    return students.size() > 0 ? students.get(0) : null;
	  }
	  
	  
	  public AverageMarks showMarks(AverageMarks mark) { 

		    String sql="select tbl_mst_avg_marks.num_avg_marks_id, tbl_mst_avg_marks.num_nominal_role_id,"+ 
"tbl_mst_avg_marks.num_avg_marks,"+ 
"tbl_mst_avg_marks.num_his_of_arrears, tbl_mst_avg_marks.num_cur_arrears,"+
"tbl_mst_sem_marks.num_sem1_mark, tbl_mst_sem_marks.num_sem2_mark, tbl_mst_sem_marks.num_sem3_mark,"+
"tbl_mst_sem_marks.num_sem4_mark, tbl_mst_sem_marks.num_sem5_mark, tbl_mst_sem_marks.num_sem6_mark,"+
"tbl_mst_sem_marks.num_sem7_mark, tbl_mst_sem_marks.num_sem8_mark, tbl_mst_sem_marks.num_sem9_mark,"+ 
"tbl_mst_sem_marks.num_sem10_mark"+
" from tbl_mst_avg_marks"+
" left outer join tbl_mst_sem_marks on (tbl_mst_avg_marks.num_avg_marks_id = tbl_mst_sem_marks.num_avg_marks_id)";      
		    List<AverageMarks> marks = jdbcTemplate.query(sql, new AverageMarksMapper());

		    return marks.size() > 0 ? marks.get(0) : null;
		  }

	  public CompanyDetails showCompanies(CompanyDetails company) {

		    String sql = "select num_company_id, vch_company_name, dtt_dop, num_percentage,"+ 
		    			 " CASE WHEN vch_his_of_arrear LIKE 'N' THEN 'NO'"+
		    			 " WHEN vch_his_of_arrear LIKE 'Y' THEN 'YES'"+
		    			 " ELSE null"+
		    			 " END AS vch_his_of_arrear,"+ 
		    			 " CASE WHEN vch_cur_arrear LIKE 'N' THEN 'NO'"+
		    			 " WHEN vch_cur_arrear LIKE 'Y' THEN 'YES'"+
		    			 " ELSE null"+
		    			 " END AS vch_cur_arrear"+
		    			 " from tbl_mst_companydetails";
// where num_Student_Id=" + student.getStudentId() ;//" and vch_student_fname='" + student.getFirstname() + "'";

		    List<CompanyDetails> companies = jdbcTemplate.query(sql, new CompanyDetailsMapper());

		    return companies.size() > 0 ? companies.get(0) : null;
		  }
		  
	  public int update(NominalRole p){  
		    String sql="update tbl_mst_nominal_role set vch_reg_number='"+p.getRegno()+"', vch_name='"+p.getName()+"', dtt_year_of_joining='"+p.getYoj()+"', num_year_id="+p.getYear()+", num_degree_id="+p.getDegree()+", num_dept_id="+p.getDept()+", num_section_id="+p.getSection()+",vch_email_id='"+p.getEmail()+"'";
		    
		     return jdbcTemplate.update(sql);  
		}
	  
	  public int update1(AverageMarks p){  
		    String sql="update tbl_mst_sem_marks set num_sem1_marks="+p.getSem1Mark()+",num_sem2_marks="+p.getSem2Mark()+",num_sem3_marks="+p.getSem3Mark()+",num_sem4_marks="+p.getSem4Mark()+",num_sem5_marks="+p.getSem5Mark()+",num_sem6_marks="+p.getSem6Mark()+",num_sem7_marks="+p.getSem7Mark()+",num_sem8_marks="+p.getSem8Mark()+",num_sem9_marks="+p.getSem9Mark()+",num_sem10_marks="+p.getSem10Mark();
		    
		           sql="update tbl_mst_avg_marks set  num_avg_marks="+p.getAvgmark()+", num_his_of_arrears="+p.getHisofarrear()+", num_cur_arrears="+p.getCurrentarrear();
	
		    return jdbcTemplate.update(sql);  
		}  
	  public int updateCompanyDetails(CompanyDetails p){  
		    String sql="update tbl_mst_companydetails set vch_comany_name='"+p.getCompanyName()+"', dtt_dop='"+p.getDop()+"', num_percentage="+p.getPercentage()+", vch_his_of_arrear="+p.getHisofarrear()+", vch_cur_arrear="+p.getCurrentarrear()+"'";
		    
		     return jdbcTemplate.update(sql);  
		}
		
	  public int delete(int id){  
		    String sql="delete from tbl_mst_nominal_role where num_nominal_role_id="+id+"";  
		    return jdbcTemplate.update(sql);  
		}  
	  public int delete1(int id){  
		    String sql="delete from tbl_mst_nominal_role where num_nominal_role_id="+id+"";  
		    return jdbcTemplate.update(sql);  
		}  
	  public int deleteCompanyDetails(int id){  
		    String sql="delete from tbl_mst_companydetails where num_company_id="+id+"";  
		    return jdbcTemplate.update(sql);  
		}  
		
	public NominalRole getNominalRoleById(int regno){  
		    String sql="select num_nominal_role_id,"+ 
		    		" vch_reg_number, vch_name,"+ 
		    		" dtt_year_of_joining,"+
		    		" tbl_mst_year.num_year_id, tbl_mst_year.num_year,"+
		    		" tbl_mst_degree.num_degree_id, tbl_mst_degree.vch_degree_name,"+
		    		" tbl_mst_dept.num_dept_id, tbl_mst_dept.vch_dept_name,"+
		    		" tbl_mst_section.num_section_id, tbl_mst_section.vch_section,"+ 
		    		" vch_email_id"+ 
		    		" from tbl_mst_nominal_role where num_nominal_role_id=?";  
		    return jdbcTemplate.queryForObject(sql, new Object[]{regno},new BeanPropertyRowMapper<NominalRole>(NominalRole.class));  
		}  
		
		public AverageMarks getAverageMarksById(int regno){  
		    String sql="select tbl_mst_avg_marks.num_avg_marks_id, tbl_mst_avg_marks.num_nominal_role_id,"+ 
"tbl_mst_avg_marks.num_avg_marks,"+ 
"tbl_mst_avg_marks.vch_his_of_arrears, tbl_mst_avg_marks.vch_cur_arrears,"+
"tbl_mst_sem_marks.num_sem1_mark, tbl_mst_sem_marks.num_sem2_mark, tbl_mst_sem_marks.num_sem3_mark,"+
"tbl_mst_sem_marks.num_sem4_mark, tbl_mst_sem_marks.num_sem5_mark, tbl_mst_sem_marks.num_sem6_mark,"+
"tbl_mst_sem_marks.num_sem7_mark, tbl_mst_sem_marks.num_sem8_mark, tbl_mst_sem_marks.num_sem9_mark,"+ 
"tbl_mst_sem_marks.num_sem10_mark"+
" from tbl_mst_avg_marks"+
" left outer join tbl_mst_sem_marks on (tbl_mst_avg_marks.num_avg_marks_id = tbl_mst_sem_marks.num_avg_marks_id) where tbl_mst_avg_marks.num_avg_marks_id=?";
		    
		    return jdbcTemplate.queryForObject(sql, new Object[]{regno},new BeanPropertyRowMapper<AverageMarks>(AverageMarks.class));  
		} 
		
		public CompanyDetails getCompanyDetailsById(int companyId){  
		    String sql="select num_company_id, vch_company_name, dtt_dop, num_percentage, vch_his_of_arrear, vch_cur_arrear from tbl_mst_companydetails where num_company_id=?";  
		    return jdbcTemplate.queryForObject(sql, new Object[]{companyId},new BeanPropertyRowMapper<CompanyDetails>(CompanyDetails.class));  
		}  
		
		
		
		public List<NominalRole> getAllNominalRoles(){  
		    return jdbcTemplate.query("select num_nominal_role_id,"+ 
		    		" vch_reg_number, vch_name,"+ 
		    		" dtt_year_of_joining,"+
		    		" tbl_mst_year.num_year_id, tbl_mst_year.num_year,"+
		    		" tbl_mst_degree.num_degree_id, tbl_mst_degree.vch_degree_name,"+
		    		" tbl_mst_dept.num_dept_id, tbl_mst_dept.vch_dept_name,"+
		    		" tbl_mst_section.num_section_id, tbl_mst_section.vch_section,"+ 
		    		" vch_email_id"+ 
		    		" from tbl_mst_nominal_role, tbl_mst_year, tbl_mst_degree, tbl_mst_dept, tbl_mst_section"+
		    		" where tbl_mst_nominal_role.num_year_id = tbl_mst_year.num_year_id"+
		    		" AND tbl_mst_nominal_role.num_degree_id = tbl_mst_degree.num_degree_id"+
		    		" AND tbl_mst_nominal_role.num_dept_id = tbl_mst_dept.num_dept_id"+
		    		" AND tbl_mst_nominal_role.num_section_id = tbl_mst_section.num_section_id"+
		    		" order by num_nominal_role_id",new RowMapper<NominalRole>(){  
		        public NominalRole mapRow(ResultSet rs, int row) throws SQLException {  
		        	NominalRole e=new NominalRole();  
		            e.setNominalRoleId(rs.getInt(1));
		        	e.setRegno(rs.getString(2));  
		            e.setName(rs.getString(3));  
		            e.setYoj(rs.getDate(4));
		            e.setYear(rs.getInt(5));
		            e.setYearName(rs.getInt(6));
		            e.setDegree(rs.getInt(7));  
		            e.setDegreeName(rs.getString(8));
		            e.setDept(rs.getInt(9));  
		            e.setDeptName(rs.getString(10));  
		            e.setSection(rs.getInt(11));
		            e.setSectionName(rs.getString(12));
		          
		            e.setEmail(rs.getString(13));
		            
		            
		            return e;  
		        }  
		    });  
		} 
		/*public List<AverageMarks> getAllAverageMarks(){  
		    return jdbcTemplate.query("select num_sem_id, vch_sem_name,  from tbl_mst_nominal_role",new RowMapper<NominalRole>(){  
		        public NominalRole mapRow(ResultSet rs, int row) throws SQLException {  
		        	AverageMarks a=new AverageMarks();
		        	a.setaveragemarksid
		            a.setNominalRoleId(rs.getInt(1));
		        	
		            e.setName(rs.getString(3));  
		            e.setDegree(rs.getInt(6));  
		            e.setDept(rs.getInt(7));  
		            e.setSection(rs.getInt(8));
		            e.setYear(rs.getInt(5));
		            e.setYoj(rs.getDate(4));
		            e.setEmail(rs.getString(9));
		            
		            
		            return e;  
		        }  
		    });  
		} */


		public List<AverageMarks> getAllAverageMarks(){
			String strSql="select tbl_mst_avg_marks.num_avg_marks_id, tbl_mst_avg_marks.num_nominal_role_id,"+ 
					"tbl_mst_avg_marks.num_avg_marks,"+ 
					"tbl_mst_avg_marks.num_his_of_arrears, tbl_mst_avg_marks.num_cur_arrears, "+
					"tbl_mst_sem_marks.num_sem1_mark, tbl_mst_sem_marks.num_sem2_mark, tbl_mst_sem_marks.num_sem3_mark, "+
					"tbl_mst_sem_marks.num_sem4_mark, tbl_mst_sem_marks.num_sem5_mark, tbl_mst_sem_marks.num_sem6_mark, "+
					"tbl_mst_sem_marks.num_sem7_mark, tbl_mst_sem_marks.num_sem8_mark, tbl_mst_sem_marks.num_sem9_mark,"+ 
					"tbl_mst_sem_marks.num_sem10_mark"+
					" from tbl_mst_avg_marks"+
					" left outer join tbl_mst_sem_marks on (tbl_mst_avg_marks.num_avg_marks_id = tbl_mst_sem_marks.num_avg_marks_id)";

			System.out.print(strSql);
		    return jdbcTemplate.query(strSql,new RowMapper<AverageMarks>(){  
		        public AverageMarks mapRow(ResultSet rs, int row) throws SQLException {  
		        	AverageMarks e =new AverageMarks(); 
		        	e.setAvgmarkId(rs.getInt(1));
		        	e.setNominalRoleId(rs.getInt(2));
		        	e.setAvgmark(rs.getInt(3));
		        	e.setHisofarrear(rs.getInt(4));
		            e.setCurrentarrear(rs.getInt(5));
		        	e.setSem1Mark(rs.getInt(6)) ; 
		        	e.setSem2Mark(rs.getInt(7)) ; 
		        	e.setSem3Mark(rs.getInt(8)) ; 
		        	e.setSem4Mark(rs.getInt(9)) ; 
		        	e.setSem5Mark(rs.getInt(10)) ; 
		        	e.setSem6Mark(rs.getInt(11)) ; 
		        	e.setSem7Mark(rs.getInt(12)) ; 
		        	e.setSem8Mark(rs.getInt(13)) ; 
		        	e.setSem9Mark(rs.getInt(14)) ; 
		        	e.setSem10Mark(rs.getInt(15)) ;
		        	 
		              
		             return e;  
		        }  
		    });  
		} 
		
		public List<CompanyDetails> getAllCompanyDetails(){  
		    return jdbcTemplate.query("select vch_company_name, dtt_dop, num_percentage,"+ 
	    			 " CASE WHEN vch_his_of_arrear LIKE 'N' THEN 'NO'"+
	    			 " WHEN vch_his_of_arrear LIKE 'Y' THEN 'YES'"+
	    			 " ELSE null"+
	    			 " END AS vch_his_of_arrear,"+ 
	    			 " CASE WHEN vch_cur_arrear LIKE 'N' THEN 'NO'"+
	    			 " WHEN vch_cur_arrear LIKE 'Y' THEN 'YES'"+
	    			 " ELSE null"+
	    			 " END AS vch_cur_arrear"+
	    			 " from tbl_mst_companydetails",new RowMapper<CompanyDetails>(){  
		        public CompanyDetails mapRow(ResultSet rs, int row) throws SQLException {  
		        	CompanyDetails e=new CompanyDetails();  
		           
		        	e.setCompanyName(rs.getString(1));  
		            e.setDop(rs.getDate(2));  
		            e.setPercentage(rs.getInt(3));  
		            e.setHisofarrear(rs.getString(4));  
		            e.setCurrentarrear(rs.getString(5));
		
		            
		            
		            return e;  
		        }  
		    });  
		} 
	
		// to load Department combobox values
		public List<ComboDO> getAllDept(){  
		    return jdbcTemplate.query("select num_dept_id, vch_dept_name from tbl_mst_dept where char_active_status='Y'",new RowMapper<ComboDO>(){  
		        public ComboDO mapRow(ResultSet rs, int row) throws SQLException {  
		        	ComboDO e=new ComboDO();  
		            e.setId(rs.getInt(1));
		        	e.setValue(rs.getString(2));		            
		            return e;  
		        }  
		    });  
		}
		public List<ComboDO> getAllDegree(int deptId){  
		    return jdbcTemplate.query("select num_degree_id, vch_degree_name from tbl_mst_degree where char_active_status='Y' AND NUM_DEPT_ID = "+deptId,new RowMapper<ComboDO>(){  
		        public ComboDO mapRow(ResultSet rs, int row) throws SQLException {  
		        	ComboDO e=new ComboDO();  
		            e.setId(rs.getInt(1));
		        	e.setValue(rs.getString(2));		            
		            return e;  
		        }  
		    });  
		}
		public List<ComboDO> getAllYear(){  
		    return jdbcTemplate.query("select num_year_id, num_year from tbl_mst_year where char_active_status='Y'",new RowMapper<ComboDO>(){  
		        public ComboDO mapRow(ResultSet rs, int row) throws SQLException {  
		        	ComboDO e=new ComboDO();  
		            e.setId(rs.getInt(1));
		        	e.setValue(rs.getString(2));		            
		            return e;  
		        }  
		    });  
		}
		public List<ComboDO> getAllSection(){  
		    return jdbcTemplate.query("select num_section_id, vch_section from tbl_mst_section where char_active_status='Y'",new RowMapper<ComboDO>(){  
		        public ComboDO mapRow(ResultSet rs, int row) throws SQLException {  
		        	ComboDO e=new ComboDO();  
		            e.setId(rs.getInt(1));
		        	e.setValue(rs.getString(2));		            
		            return e;  
		        }  
		    });  
		}
		public List<ComboDO> getAllRegno(){  
		    return jdbcTemplate.query("select num_nominal_role_id, vch_reg_number from tbl_mst_nominal_role where char_active_status='Y'",new RowMapper<ComboDO>(){  
		        public ComboDO mapRow(ResultSet rs, int row) throws SQLException {  
		        	ComboDO e=new ComboDO();  
		            e.setId(rs.getInt(1));
		        	e.setValue(rs.getString(2));		            
		            return e;  
		        }  
		    });  
		}
		
//to load Semester combobox values
		public List<ComboDO> getAllSem(){  
		    return jdbcTemplate.query("select num_sem_id, vch_sem_name from tbl_mst_semesters where char_active_status='Y'",new RowMapper<ComboDO>(){  
		        public ComboDO mapRow(ResultSet rs, int row) throws SQLException {  
		        	ComboDO e=new ComboDO();  
		            e.setId(rs.getInt(1));
		        	e.setValue(rs.getString(2));		            
		            return e;  
		        }  
		    });  
		}
	class NominalRoleMapper implements RowMapper<NominalRole> {

	  public NominalRole mapRow(ResultSet rs, int arg1) throws SQLException {
		  NominalRole student = new NominalRole();
		  student.setNominalRoleId(rs.getInt("num_nominal_role_id"));
		  student.setRegno(rs.getString("vch_regno"));
		  student.setName(rs.getString("vch_name"));
		  student.setYoj(rs.getDate("dtt_year_of_joining"));
		  student.setYear(rs.getInt("num_year_id"));
		  student.setDegree(rs.getInt("num_degree_id"));
		  student.setDept(rs.getInt("num_dept_id"));
		  student.setSection(rs.getInt("num_section_id"));
		  student.setEmail(rs.getString("vch_email_id"));
		  
	    return student;
	  }
	}
	

class AverageMarksMapper implements RowMapper<AverageMarks> {

	  public AverageMarks mapRow(ResultSet rs, int arg1) throws SQLException {
		  AverageMarks marks = new AverageMarks();

		  marks.setAvgmarkId(rs.getInt("num_avg_marks_id"));
		  marks.setNominalRoleId(rs.getInt("num_nominal_role_id"));
		  marks.setAvgmark(rs.getInt("num_avg_marks"));
		  marks.setHisofarrear(rs.getInt("num_his_of_arrears"));
		  marks.setCurrentarrear(rs.getInt("num_cur_arrears"));
		  marks.setSem1Mark(rs.getInt("num_sem1_mark"));
		  marks.setSem2Mark(rs.getInt("num_sem2_mark"));
		  marks.setSem3Mark(rs.getInt("num_sem3_mark"));
		  marks.setSem4Mark(rs.getInt("num_sem4_mark"));
		  marks.setSem5Mark(rs.getInt("num_sem5_mark"));
		  marks.setSem6Mark(rs.getInt("num_sem6_mark"));
		  marks.setSem7Mark(rs.getInt("num_sem7_mark"));
		  marks.setSem8Mark(rs.getInt("num_sem8_mark"));
		  marks.setSem9Mark(rs.getInt("num_sem9_mark"));
		  marks.setSem10Mark(rs.getInt("num_sem10_mark"));
		  
		  
		  
	    return marks;
	  }
	}
class CompanyDetailsMapper implements RowMapper<CompanyDetails> {

	  public CompanyDetails mapRow(ResultSet rs, int arg1) throws SQLException {
		  CompanyDetails company = new CompanyDetails();
		  company.setCompanyId(rs.getInt("num_company_id"));
		  company.setCompanyName(rs.getString("vch_company_name"));
		  company.setDop(rs.getDate("dtt_dop"));
		  company.setPercentage(rs.getInt("num_percentage"));
		  company.setHisofarrear(rs.getString("vch_his_of_arrear"));
		  company.setCurrentarrear(rs.getString("vch_cur_arrear"));
		 
	    return company;
	  }
	}

		
}
		  
		  
		  
		 
