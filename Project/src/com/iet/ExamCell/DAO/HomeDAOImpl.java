
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

		  String sql= "insert into tbl_mst_avg_marks (num_nominal_role_id, num_avg_marks, num_his_of_arrears, num_cur_arrears)"+ "values(?,?,?,?)";	
		    
		  jdbcTemplate.update1(sql, new Object[] {marks.getMark(), marks.getAvgmarks(), marks.getHisofarrears(), marks.getCurrentarrears()});
			      
		  sql = "SELECT max(num_avg_marks_id) from tbl_mst_avg_marks";
		  int avg_mark_id = jdbcTemplate.queryForObject(sql, Integer.class);
			
		  sql = "insert into tbl_mst_sem_marks (num_avg_marks_id, num_nominal_role_id, num_sem_id, num_sem_marks) "
		    		+ "values(?,?,?,?)";
           	    
		  jdbcTemplate.update1(sql, new Object[] { marks.getAvgmarksId(), marks.getNominalRoleId(),
		    	marks.getSemester(), marks.getMark()});
		  
		    
		
	  }


	  public NominalRole showStudents(NominalRole student) {

	    String sql = "select num_nominal_role_id, vch_reg_number, vch_name, dtt_year_of_joining, num_year_id, num_degree_id, num_dept_id,num_section_id, vch_email_id from tbl_mst_nominal_role";// where num_Student_Id=" + student.getStudentId() ;//" and vch_student_fname='" + student.getFirstname() + "'";

	    List<NominalRole> students = jdbcTemplate.query(sql, new NominalRoleMapper());

	    return students.size() > 0 ? students.get(0) : null;
	  }
	  public AverageMarks showMarks(AverageMarks mark) { 

		    String sql = "select num_avg_marks_id,num_nominal_role, num_avg_marks, num_his_of_arrears, num_cur_arrears from tbl_mst_avg_marks";
		    
		    sql = "select  num_avg_marks_id, num_sem_id, num_sem_marks from tbl_mst_sem,_marks";
		            

		    List<AverageMarks> marks = jdbcTemplate.query(sql, new AverageMarksMapper());

		    return marks.size() > 0 ? marks.get(0) : null;
		  }

	  public int update(NominalRole p){  
		    String sql="update tbl_mst_nominal_role set vch_reg_number='"+p.getRegno()+"', vch_name='"+p.getName()+"', dtt_year_of_joining='"+p.getYoj()+"', num_year_id="+p.getYear()+", num_degree_id="+p.getDegree()+", num_dept_id="+p.getDept()+", num_section_id="+p.getSection()+",vch_email_id='"+p.getEmail()+"'";
		    
		     return jdbcTemplate.update(sql);  
		}  
	  public int update1(AverageMarks p){  
		    String sql="update tbl_mst_sem_marks set vch_reg_no='"+p.getRegno()+"', num_sem_id="+p.getSemester()+", num_sem_marks="+p.getMark();
		    
		           sql="update tbl_mst_avg_marks set  num_avg_marks="+p.getAvgmarks()+", num_his_of_arrears="+p.getHisofarrears()+", num_current_arrears="+p.getCurrentarrears();
	
		    return jdbcTemplate.update1(sql);  
		    return jdbcTemplate.update1(sql);
		}  
		public int delete(int id){  
		    String sql="delete from tbl_mst_nominal_role where num_nominal_role_id="+id+"";  
		    return jdbcTemplate.update(sql);  
		}  
		public int delete1(int id){  
		    String sql="delete from tbl_mst_sem_marks where num_sem_marks_id="+id+"";  
		    return jdbcTemplate.update1(sql);  
		}
		public NominalRole getNominalRoleById(int regno){  
		    String sql="select num_nominal_role_id, vch_name, dtt_year_of_joining, num_year_id, num_degree_id, num_dept_id, num_section_id, vch_email_id from tbl_mst_nominal_role where num_nominal_role_id=?";  
		    return jdbcTemplate.queryForObject(sql, new Object[]{regno},new BeanPropertyRowMapper<NominalRole>(NominalRole.class));  
		}  
		public AverageMarks getAverageMarksById(int regno){  
		    String sql="select num_sem_marks, num_sem_id, num_sem_marks from tbl_mst_sem_marks where num_sem_marks_id=?"+"select vch_reg_no, num_avg_marks, num_his_of_arrears, num_cur_arrears where num_sem_marks_id=?";  
		    return jdbcTemplate.queryForObject(sql, new Object[]{regno},new BeanPropertyRowMapper<AverageMarks>(AverageMarks.class));  
		} 
		public List<NominalRole> getAllNominalRoles(){  
		    return jdbcTemplate.query("select num_nominal_role_id, vch_reg_no, num_sem_id, num_marks from tbl_mst_sem_marks"+"select num_vg_marks, num_his_of_arrears, num_cur_arrears from tbl_mst_avg_marks",new RowMapper<NominalRole>(){  
		        public NominalRole mapRow(ResultSet rs, int row) throws SQLException {  
		        	NominalRole e=new NominalRole();  
		            e.setNominalRoleId(rs.getInt(1));
		        	e.setRegno(rs.getString(2));  
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
		} 
		
		public List<AverageMarks> getAllAverageMarks(){  
		    return jdbcTemplate.query("select num_sem_marks_id, vch_reg_no, num_sem_id, num_sem_marks from tbl_mst_sem_marks"+"select num_avg_marks, num_his_of_arrears, num_cur_arrears from tbl_mst_avg_ma",new RowMapper<AverageMarks>(){  
		        public AverageMarks mapRow(ResultSet rs, int row) throws SQLException {  
		        	AverageMarks e =new AverageMarks();  
		            e.setSemmarksId(rs.getInt(1));
		        	e.setRegno(rs.getString(2));  
		            e.setSemester(rs.getInt(3));  
		            e.setMark(rs.getInt(4));  
		            e.setAvgmarks(rs.getInt(5));  
		            e.setHisofarrears(rs.getInt(6));
		            e.setCurrentarrears(rs.getInt(7));
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
		public List<ComboDO> getAllDegree(){  
		    return jdbcTemplate.query("select num_degree_id, vch_degree_name from tbl_mst_degree where char_active_status='Y'",new RowMapper<ComboDO>(){  
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
		
//to load Semester combobox values
		public List<ComboDO> getAllSemester(){  
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
			  marks.setSemmarksId(rs.getInt("num_sem_marks_id"));
			  marks.setRegno(rs.getString("vch_regno"));
			  marks.setSemester(rs.getInt("num_sem_id"));
			  marks.setMark(rs.getInt("num_sem_marks"));
			  marks.setAvgmarks(rs.getInt("num_avg_marks"));
			  marks.setHisofarrears(rs.getInt("num_his_of_arrears"));
			  marks.setCurrentarrears(rs.getInt("num_cur_arrears"));
			  
			  
		    return marks;
		  }
		}
	

	
}
		  
		  
		  
		  
		 
