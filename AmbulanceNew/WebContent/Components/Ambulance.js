$(document).ready(function() 
		{  
	if ($("#alertSuccess").text().trim() == "")  
    {   
		$("#alertSuccess").hide();  
     }  
	     $("#alertError").hide(); 
	  
});

$(document).on("click", "#btnSave", function(event) 
		{  
			$("#alertSuccess").text("");  
			$("#alertSuccess").hide();  
			$("#alertError").text("");  
			$("#alertError").hide(); 
			
			
			var status = validateAmbulanceForm();  
			if (status != true)  
			{   
				$("#alertError").text(status);   
				$("#alertError").show();   
				return;  
			} 
			
			var type = ($("#hiddriverIDSave").val() == "") ? "POST" : "PUT"; 
			
			$.ajax( 
			{  
				url : "AmbulanceAPI",  
				type : type,  
				data : $("#formAmbulance").serialize(),  
				dataType : "text",  
				complete : function(response, status)  
				{   
					onAmbulanceSaveComplete(response.responseText, status);  
					
				} 
			
		}); 
}); 
		
function onAmbulanceSaveComplete(response, status) 
{  
	if (status == "success")  
	{   
		var resultSet = JSON.parse(response); 

		if (resultSet.status.trim() == "success")   
		{    
			$("#alertSuccess").text("Successfully saved.");    
			$("#alertSuccess").show(); 

			$("#divAmbulanceDetailsGrid").html(resultSet.data);   
		} else if (resultSet.status.trim() == "error")   
		{    
			$("#alertError").text(resultSet.data);    
			$("#alertError").show();   
		} 

		} else if (status == "error")  
		{   
			$("#alertError").text("Error while saving.");   
			$("#alertError").show();  
		} else  
		{   
			$("#alertError").text("Unknown error while saving..");   
			$("#alertError").show();  
		} 

		$("#hiddriverIDSave").val("");  
		$("#formAmbulance")[0].reset(); 
		
}

$(document).on("click", ".btnRemove", function(event) 
{  
	$.ajax(  
	{   
		url : "AmbulanceAPI",   
		type : "DELETE",   
		data : "driverID=" + $(this).data("driverid"),   
		dataType : "text",   
		complete : function(response, status)   
		{    
			onAmbulanceDeleteComplete(response.responseText, status);   
		}  
	}); 
}); 


function onAmbulanceDeleteComplete(response, status) 
{  
	if (status == "success")  
	{   
		var resultSet = JSON.parse(response); 

		if (resultSet.status.trim() == "success")   
		{    
			$("#alertSuccess").text("Successfully deleted.");    
			$("#alertSuccess").show(); 

			$("#divAmbulanceDetailsGrid").html(resultSet.data);   
			} else if (resultSet.status.trim() == "error")   
			{    
				$("#alertError").text(resultSet.data);    
				$("#alertError").show();   
			} 

			} else if (status == "error")  
			{   
				$("#alertError").text("Error while deleting.");   
				$("#alertError").show();  
			} else  
			{   
				$("#alertError").text("Unknown error while deleting..");   
				$("#alertError").show();  
			} 
	} 

$(document).on("click", ".btnUpdate", function(event) 
{     
	$("#hiddriverIDSave").val($(this).closest("tr").find('#hiddriverIDUpdate').val());     
	$("#driverCode").val($(this).closest("tr").find('td:eq(0)').text());     
	$("#driverName").val($(this).closest("tr").find('td:eq(1)').text());     
	$("#mobileNo").val($(this).closest("tr").find('td:eq(2)').text());     
	$("#vehicleNo").val($(this).closest("tr").find('td:eq(3)').text()); 
}); 


function validateAmbulanceForm() 
{  
	// CODE  
	if ($("#driverCode").val().trim() == "")  
	{   
		return "Insert Driver Code.";   
	}

	 
	 // NAME  
	if ($("#driverName").val().trim() == "")  
	{   
		return "Insert Driver Name.";  
	}
	
	if ($("#mobileNo").val().trim() == "")  
	{   
		return "Insert Mobile No.";  
	} 
	 
	 // is numerical value  
	var tmpmobileNo = $("#mobileNo").val().trim();  
	if (!$.isNumeric(tmpmobileNo))  
	{   
		return "Insert a numerical value for Mobile No.";  
	} 
	 

	
	
	 
	 // DESCRIPTION------------------------  
	if ($("#vehicleNo").val().trim() == "")  
	{   
		return "Insert Vehicle No.";  
		
	} 
	 
	 return true;
	
}