
<%@page import="Com.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ambulance Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<script src="Components/jquery-3.2.1.min.js"></script> 
<script src="Components/Ambulance.js"></script> 
</head> 
<body> 
<div class="container">
 <div class="row"> <div class="col-6">  
 <h1>Ambulance Management </h1> 
 
<form id="formAmbulance" name="formAmbulance" >  
 
 Driver code:   
 <input id="driverCode" name="driverCode" type="text"     class="form-control form-control-sm"> 
 
  <br> Driver name:   
  <input id="driverName" name="driverName" type="text"        class="form-control form-control-sm"> 
 
  <br> Mobile No:   
  <input id="mobileNo" name="mobileNo" type="text"        class="form-control form-control-sm"> 
 
  <br> Vehicle No:   
  <input id="vehicleNo" name="vehicleNo" type="text"        class="form-control form-control-sm"> 
 
  <br>   
  <input id="btnSave" name="btnSave" type="button" value="Save"      
  class="btn btn-primary">   <input type="hidden" id="hiddriverIDSave"         
  name="hiddriverIDSave" value="">  </form> 
 
 <div id="alertSuccess" class="alert alert-success"></div>  
 <div id="alertError" class="alert alert-danger"></div> 
 
 <br>  <div id="divAmbulanceDetailsGrid">   
 <%    
 Ambulance ambulanceObj = new Ambulance();    
 	out.print(ambulanceObj.readAmbulanceDetails());   
 %>  
 </div>
 </div>
 </div>
 </div>
 </body>
 </html>
 