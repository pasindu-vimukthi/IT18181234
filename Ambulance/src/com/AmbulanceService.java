package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Ambulance;

@Path("/Ambulance")

public class AmbulanceService {

	Ambulance ambObj = new Ambulance(); 
	
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String insertAmbulanceDetails(@FormParam("driverCode") String driverCode,      
							@FormParam("driverName") String driverName,    
							@FormParam("mobileNo") String mobileNo,      
							@FormParam("vehicleNo") String vehicleNo)
	{  
		String output = ambObj.insertAmbulanceDetails(driverCode, driverName, mobileNo, vehicleNo);  
		return output; 
	} 
	 
	 @GET  
	 @Path("/")  
	 @Produces(MediaType.TEXT_HTML) 
	public String readAmbulanceDetails()  
	 {   
		 return ambObj.readAmbulanceDetails();
		 
	 } 
	 
	 
	 @PUT 
	 @Path("/")
	 @Consumes(MediaType.APPLICATION_JSON) 
	 @Produces(MediaType.TEXT_PLAIN) 
	 public String updateAmbulanceDetails(String ambulanceData)
	 {  
		 
		 JsonObject ambObject = new JsonParser().parse(ambulanceData).getAsJsonObject(); 
		 
		 String driverID = ambObject .get("driverID").getAsString();  
		 String driverCode = ambObject .get("driverCode").getAsString();  
		 String driverName = ambObject .get("driverName").getAsString();  
		 String mobileNo = ambObject .get("mobileNo").getAsString();  
		 String vehicleNo = ambObject .get("vehicleNo").getAsString(); 
		 
		 String output = ambObj.updateAmbulanceDetails(driverID, driverCode, driverName, mobileNo, vehicleNo); 
		 
		 return output; 
		 
	 } 
	 
	 
	 @DELETE 
	 @Path("/") 
	 @Consumes(MediaType.APPLICATION_XML) 
	 @Produces(MediaType.TEXT_PLAIN) 
	 public String deleteAmbulanceDetails(String ambulanceData)
	 {   
		 Document doc = Jsoup.parse(ambulanceData, "", Parser.xmlParser());     
		 String driverID = doc.select("driverID").text(); 
		 
		 String output = ambObj.deleteAmbulanceDetails(driverID); 
		 
		 return output; } 
	 
	 
}




