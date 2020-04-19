package model;

import java.sql.*;

public class Hospital {

	private Connection connect()  {   
		
		Connection con = null; 
	 
	  try   
	  {     
		  Class.forName("com.mysql.jdbc.Driver");              
		  con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospitaldb", "root", "");   
		  
	  }   
	  catch (Exception e)   
	  {e.printStackTrace();} 
	 
	  return con;  
	  } 
	
	public String insertHosDetails(String hosname, String address, String contactno, String email) 
	{   
		String output = ""; 
	 try   
	  {    
		  Connection con = connect(); 
	 
	   if (con == null)   
	   {
		   return "Error while connecting to the database for inserting."; } 
	 
	      String query = " insert into hospitaldetails (`hosID`,`hosName`,`hosAddress`,`hosContactno`,`hosEmail`)"     
	    		  + " values (?, ?, ?, ?, ?)"; 
	 
	      PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	      preparedStmt.setInt(1, 0);   
	      preparedStmt.setString(2, hosname);   
	      preparedStmt.setString(3, address);    
	      preparedStmt.setString(4, contactno);   
	      preparedStmt.setString(5, email); 
	 
	   
	      preparedStmt.execute();    
	      con.close(); 
	 
	   output = "Inserted successfully";   
	   
	  }catch (Exception e)   
	  	
	 	{    
		   output = "Error while inserting the Details";    
		   System.err.println(e.getMessage());   
		} 
	 return output;  
	}
	
	
public String readHosDetails()  
	{   
		String output = ""; 

		try   
		{   
			Connection con = connect(); 
		
			if (con == null)    
			{
				return "Error while connecting to the database for reading."; 
			} 
			
	 
	     output = "<table border=\"1\"><tr><th>Hospital Name</th><th>Address</th><th>Contact No</th><th>Email</th><th>Update</th><th>Remove</th></tr>"; 
	 
	   
	     String query = "select * from hospitaldetails";    
	     Statement stmt = con.createStatement();    
	     ResultSet rs = stmt.executeQuery(query); 
	 
	     while (rs.next())    
	     {     
	    	 String hosID = Integer.toString(rs.getInt("hosID"));     
	    	 String hosName = rs.getString("hosName");     
	    	 String hosAddress = rs.getString("hosAddress");     
	    	 String hosContactno = Integer.toString(rs.getInt("hosContactno"));     
	    	 String hosEmail = rs.getString("hosEmail"); 
	     
	 
	         output += "<tr><td>" + hosName + "</td>";     
	         output += "<td>" + hosAddress + "</td>";     
	         output += "<td>" + hosContactno + "</td>";     
	         output += "<td>" + hosEmail + "</td>"; 
	 
	         output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>"      
	         				+ "<td><form method=\"post\" action=\"items.jsp\">"      
	         				+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"      
	         				+ "<input name=\"itemID\" type=\"hidden\" value=\"" + hosID      
	         				+ "\">" + "</form></td></tr>";    
	         } 
	
	     con.close(); 
	 
	     output += "</table>";   
	     }   
		catch (Exception e)  
		{    
			output = "Error while reading the Details.";   
			System.err.println(e.getMessage());   
		} 
	 
	  return output;  
	  } 
	
	public String updateHosDetails( String ID, String hosname, String address, String contactno, String email)  
	{   
		String output = ""; 
	 
		try   
		{    
				Connection con = connect(); 
	 
				if (con == null)   
				{
					return "Error while connecting to the database for updating."; 
				} 
	 
	   String query = "UPDATE hospitaldetails SET hosName=?,hosAddress=?,hosContactno=?,hosEmail=? WHERE hosID=?"; 
	 
	   PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	   preparedStmt.setString(1, hosname);    
	   preparedStmt.setString(2, address);   
	   preparedStmt.setDouble(3, Integer.parseInt(contactno));    
	   preparedStmt.setString(4, email);    
	   preparedStmt.setInt(5, Integer.parseInt(ID)); 
	 
	   preparedStmt.execute();   
	   con.close(); 
	 
	   output = "Updated successfully";   
	}   
		catch (Exception e)   
	{    
			output = "Error while updating the Details.";    
			System.err.println(e.getMessage());   
			
	} 
	 
	  return output;  
	  
	}
	
	public String deleteHosDetails(String hosID)  
	{   
		String output = ""; 
	 
	  try   
	  {    
		  Connection con = connect(); 
	 
	   if (con == null)    
	   {
		   return "Error while connecting to the database for deleting."; } 
	 
	   String query = "delete from hospitaldetails where hosID=?"; 
	 
	   PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	   preparedStmt.setInt(1, Integer.parseInt(hosID)); 
	 
	   preparedStmt.execute();    
	   con.close(); 
	 
	   output = "Deleted successfully"; 
	   
	  }   
	  catch (Exception e)   
	  {    
		  output = "Error while deleting the Details.";    
		  System.err.println(e.getMessage());   } 
	 
	  return output;  }
	
	
}
