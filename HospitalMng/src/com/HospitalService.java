package com;

import model.Hospital; 

import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType;
import com.google.gson.*; 
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document;

@Path("/Hospital") 
public class HospitalService {

	Hospital hosObj = new Hospital(); 
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertHosDetails(@FormParam("hosName") String hosName,      
							@FormParam("hosAddress") String hosAddress,    
							@FormParam("hosContactno") String hosContactno,      
							@FormParam("hosEmail") String hosEmail)
	{  
		String output = hosObj.insertHosDetails(hosName, hosAddress, hosContactno, hosEmail);  
		return output; 
	} 
	 
	 @GET  
	 @Path("/")  
	 @Produces(MediaType.TEXT_HTML) 
	public String readHosDetails()  
	 {   
		 return hosObj.readHosDetails();
		 
	 } 
	 
	 
	 @PUT 
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_JSON) 
	 @Produces(MediaType.TEXT_PLAIN) 
	 public String updateHosDetails(String hospitalData)
	 {  
		 
		 JsonObject hosObject = new JsonParser().parse(hospitalData).getAsJsonObject(); 
		 
		 String hosID = hosObject.get("hosID").getAsString();  
		 String hosName = hosObject.get("hosName").getAsString();  
		 String hosAddress = hosObject.get("hosAddress").getAsString();  
		 String hosContactno = hosObject.get("hosContactno").getAsString();  
		 String hosEmail = hosObject.get("hosEmail").getAsString(); 
		 
		 String output = hosObj.updateHosDetails(hosID, hosName, hosAddress, hosContactno, hosEmail); 
		 
		 return output; 
		 
	 } 
	 
	 
	 @DELETE 
	 @Path("/") 
	 @Consumes(MediaType.APPLICATION_XML) 
	 @Produces(MediaType.TEXT_PLAIN) 
	 public String deleteHosDetails(String hosData)
	 {   
		 Document doc = Jsoup.parse(hosData, "", Parser.xmlParser());     
		 String hosID = doc.select("hosID").text(); 
		 
		 String output = hosObj.deleteHosDetails(hosID); 
		 
		 return output; } 
	 
	 
}
