package Com;


import java.io.IOException; 
import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/AmbulanceAPI") 
public class AmbulanceAPI extends HttpServlet 
{  
	private static final long serialVersionUID = 1L;
	
	Ambulance ambulanceObj = new Ambulance();
	
	public AmbulanceAPI()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException 
	{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException 
	{  
		String output = ambulanceObj.insertAmbulanceDetails(request.getParameter("driverCode"),      
				request.getParameter("driverName"),     
				request.getParameter("mobileNo"),       
				request.getParameter("vehicleNo")); 
	 
	 response.getWriter().write(output); 
	 
	} 
	 
	protected void doPut(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException 
	{  
		Map paras = getParasMap(request); 
	 
	 String output = ambulanceObj.updateAmbulanceDetails(paras.get("hiddriverIDSave").toString(),     
			 paras.get("driverCode").toString(),     
			 paras.get("driverName").toString(),        
			 paras.get("mobileNo").toString(),        
			 paras.get("vehicleNo").toString()); 
	 
	 response.getWriter().write(output); } 
	 
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)    
			throws ServletException, IOException 
	{  
		Map paras = getParasMap(request); 
	 
	 String output = ambulanceObj.deleteAmbulanceDetails(paras.get("driverID").toString()); 
	 
	 response.getWriter().write(output); 
	}
	
	// Convert request parameters to a Map 
	private static Map getParasMap(HttpServletRequest request) 
	{  
		Map<String, String> map = new HashMap<String, String>();  
		try  
		{   
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");   
			String queryString = scanner.hasNext() ?          
					scanner.useDelimiter("\\A").next() : "";  
					scanner.close(); 
	 
	  String[] params = queryString.split("&");   
	  for (String param : params)   
	  { 

 
	   String[] p = param.split("=");    
	   map.put(p[0], p[1]);   
	   }  
	  }  
		catch (Exception e)  
		{  
			
		}  return map; }

	
}
