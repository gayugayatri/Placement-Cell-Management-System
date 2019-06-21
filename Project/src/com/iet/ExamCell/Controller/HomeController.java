/**
 * 
 */
package com.iet.ExamCell.Controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iet.ExamCell.Model.AverageMarks;
import com.iet.ExamCell.Model.ComboDO;
import com.iet.ExamCell.Model.IetNonIet;
import com.iet.ExamCell.Model.Login;
import com.iet.ExamCell.Model.NominalRole;
import com.iet.ExamCell.Service.HomeService;

@Controller
public class HomeController {  
	
	@Autowired
	HomeService homeService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("Home Page Requested, locale = " + locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		Login login=new Login();
		model.addAttribute("login",login);
		return "Login";
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") Login login) {
	    ModelAndView mav = null;
	    Login user = homeService.validateUser(login);
	    if (null != user) {
	    mav = new ModelAndView("Dashboard");
	    mav.addObject("username", user.getUsername()); 
	    } else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Username or Password is wrong!!");
	    }
	    return mav;
	  }
	
	/*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/nominalRole")  
    public String showform(Map<String, Object> model){  
    	model.put("nominalRole", new NominalRole());
    	
    	/*NominalRole nominalRole=homeService.getNominalRoleById(id);  
        m.addAttribute("command",nominalRole);*/
        
        List<ComboDO> deptList = homeService.getAllDept();
        model.put("deptList", deptList);
        List<ComboDO> degreeList = homeService.getAllDegree();
        model.put("degreeList", degreeList);
        List<ComboDO> yearList = homeService.getAllYear();
        model.put("yearList", yearList);
        List<ComboDO> sectionList = homeService.getAllSection();
        model.put("sectionList", sectionList);
        
    	/*List<String> yearList = new ArrayList<>();
    	yearList.add("1");
    	yearList.add("2");
    	yearList.add("3");
        model.put("yearList", yearList);
        
        List<String> degreeList = new ArrayList<>();
        degreeList.add("1");
        degreeList.add("2");
        degreeList.add("3");
        model.put("degreeList", degreeList);*/

        /*List<String> deptList = new ArrayList<>();
        deptList.add("CT");
        deptList.add("IT");
        model.put("deptList", deptList);

        List<String> sectionList = new ArrayList<>();
        sectionList.add("1");
        sectionList.add("2");
        sectionList.add("3");
        model.put("sectionList", sectionList);*/
        
    	return "NominalRole"; 
    } 
    
    @RequestMapping("/averagemarks")  
    public String showform1(Map<String, Object> model){  
    	model.put("averagemarks", new AverageMarks());
    	
    	/*List<ComboDO> semList = homeService.getAllsem();
        model.put("semList", semList);*/
    	
    	return "AverageMarks";
    	
    	
    }
    @RequestMapping("/ietnoniet")  
    public String showforms2(Map<String, Object> model){  
    	model.put("ietnoniet", new IetNonIet());
    	
    	/*List<ComboDO> semList = homeService.getAllsem();
        model.put("semList", semList);*/
    	
    	return "IetNonIet";
    	
    	
    }
   
    

    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/saveNominalRole",method = RequestMethod.POST)  
    public String saveNominalRole(@ModelAttribute NominalRole nominalRole){  
    	if(nominalRole.getNominalRoleId()>0)
    	{
    		homeService.update(nominalRole);
    	}
    	else
    	{
    		homeService.saveNominalRole(nominalRole);  
    	}
        return "redirect:/viewNominalRole";//will redirect to viewNominalRole request mapping  
    }  
    
    @RequestMapping(value="/saveAverageMarks",method = RequestMethod.POST)  
    public String saveAverageMarks(@ModelAttribute AverageMarks averageMarks){  
    	if(averageMarks.getSemmarksId()>0)
    	{
    		homeService.update1(averageMarks);
    	}
    	else
    	{
    		homeService.saveAverageMarks(averageMarks);  
    	}
        return "redirect:/viewAverageMarks";//will redirect to viewNominalRole request mapping  
    } 
    
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/edit/{id}")  
    public String edit(@PathVariable int id, Model m){  
    	NominalRole nominalRole=homeService.getNominalRoleById(id);  
        m.addAttribute("command",nominalRole);
        return "NominalRole";  
          
        }
    @RequestMapping(value="/Edit/{id}")  
    public String Edit(@PathVariable int id, Model m){  
    	AverageMarks averageMarks=homeService.getAverageMarksById(id);  
        m.addAttribute("command",averageMarks);
        return "AverageMarks";  
          
        }
    
    
    
    /* It updates Nominal Role by passing the model object NominallRole as parameter */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("nominalRole") NominalRole nominalRole){  
    	homeService.saveNominalRole(nominalRole);  
        return "redirect:/viewNominalRole";  
    }  
    @RequestMapping(value="/Editsave",method = RequestMethod.POST)  
    public String Editsave(@ModelAttribute("averageMarks") AverageMarks averageMarks){  
    	homeService.saveAverageMarks(averageMarks);  
        return "redirect:/viewAverageMarks";  
    }  
    
    /* It provides list of students through the model object - NominallRole */  
    @RequestMapping("/viewNominalRole")  
    public String viewNominalRole(Model m){  
        List<NominalRole> list=homeService.getAllNominalRoles();  
        m.addAttribute("list",list);
        return "ViewNominalRole";  
    } 
    @RequestMapping("/viewAverageMarks")  
    public String viewAverageMarks(Model m){  
        List<AverageMarks> list=homeService.getAllAverageMarks();  
        m.addAttribute("list",list);
        return "ViewAverageMarks";  
    } 
}
