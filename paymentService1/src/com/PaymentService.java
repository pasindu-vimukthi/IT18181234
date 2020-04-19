package com;

import model.Payment;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/payments")


public class PaymentService {
	Payment paymentObj = new Payment();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPayments() {
		return paymentObj.readPayments();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertPayment(@FormParam("PaymentAmount") String PaymentAmount, 
			@FormParam("Appoiment") String Appoiment,
			@FormParam("PatientID") String PatientID) {
		String output = paymentObj.insertPayment(PaymentAmount, Appoiment, PatientID);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePayment(String PaymentData) {
		// Convert the input string to a JSON object
		JsonObject PaymentObject = new JsonParser().parse(PaymentData).getAsJsonObject();
		// Read the values from the JSON object
		String PaymentID = PaymentObject.get("PaymentID").getAsString();
		String PaymentAmount = PaymentObject.get("PaymentAmount").getAsString();
		String Appoiment = PaymentObject.get("Appoiment").getAsString();
		String PatientID = PaymentObject.get("PatientID").getAsString();
		String output = paymentObj.updatePayment(PaymentID, PaymentAmount, Appoiment, PatientID);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePayment(String PaymentData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(PaymentData, "", Parser.xmlParser());

		// Read the value from the element <PaymentID>
		String paymentID = doc.select("paymentID").text();
		String output = paymentObj.deletePayment(paymentID);
		return output;
	}
}
