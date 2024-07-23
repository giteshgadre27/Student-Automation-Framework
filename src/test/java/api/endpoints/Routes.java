package api.endpoints;

public class Routes {
	
	//base url
	  public static String base_url="http://localhost:5555/restv2/Students";
	  
	 // http://localhost:5555/restv2/Students/getAllStudents
	  
	  //get all students url
	  public static String  get_url=base_url+"/getAllStudents";
	  
	  //add new student url
	   public static String post_url=base_url+"/addStudents";
		
	  //update student by Id url
	   public static String update_url=base_url+"/updateStudentById";
	  
	   //get student by Id url
	  public static String getById_url=base_url+"/getStudentById";
	  
	  //delete student by Id
	  public static String delete_url=base_url+"/deleteStudents";


}
