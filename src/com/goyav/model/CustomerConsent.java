package com.goyav.model;

import java.util.Date;

public class CustomerConsent {
	
	private Customer Customer;
	private String Siret;
	private Boolean UsingGeneralConditions;
	private Boolean Newsletters;
	private Boolean CommercialOffersByMail;
	private Boolean CommercialOffersBySms;
	private Boolean CommercialOffersByPost;
	private String Signature;
	private Date CreatedAt;
	
	public CustomerConsent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerConsent(Customer customer,String siret, Boolean usingGeneralConditions,
			Boolean newsletters, Boolean commercialOffersByMail, Boolean commercialOffersBySms,
			Boolean commercialOffersByPost, String signature, Date createdAt) {
		super();
		Customer = customer;
		Siret = siret;
		UsingGeneralConditions = usingGeneralConditions;
		Newsletters = newsletters;
		CommercialOffersByMail = commercialOffersByMail;
		CommercialOffersBySms = commercialOffersBySms;
		CommercialOffersByPost = commercialOffersByPost;
		Signature = signature;
		CreatedAt = createdAt;
	}
	public CustomerConsent(String siret, Boolean usingGeneralConditions,
			Boolean newsletters, Boolean commercialOffersByMail, Boolean commercialOffersBySms,
			Boolean commercialOffersByPost, String signature, Date createdAt) {
		super();
		Siret = siret;
		UsingGeneralConditions = usingGeneralConditions;
		Newsletters = newsletters;
		CommercialOffersByMail = commercialOffersByMail;
		CommercialOffersBySms = commercialOffersBySms;
		CommercialOffersByPost = commercialOffersByPost;
		Signature = signature;
		CreatedAt = createdAt;
	}


	public Customer getCustomer() {
		return Customer;
	}

	public void setCustomer(Customer customer) {
		Customer = customer;
	}

	public String getSiret() {
		return Siret;
	}

	public void setSiret(String siret) {
		Siret = siret;
	}

	public Boolean getUsingGeneralConditions() {
		return UsingGeneralConditions;
	}

	public void setUsingGeneralConditions(Boolean usingGeneralConditions) {
		UsingGeneralConditions = usingGeneralConditions;
	}

	public Boolean getNewsletters() {
		return Newsletters;
	}

	public void setNewsletters(Boolean newsletters) {
		Newsletters = newsletters;
	}

	public Boolean getCommercialOffersByMail() {
		return CommercialOffersByMail;
	}

	public void setCommercialOffersByMail(Boolean commercialOffersByMail) {
		CommercialOffersByMail = commercialOffersByMail;
	}

	public Boolean getCommercialOffersBySms() {
		return CommercialOffersBySms;
	}

	public void setCommercialOffersBySms(Boolean commercialOffersBySms) {
		CommercialOffersBySms = commercialOffersBySms;
	}

	public Boolean getCommercialOffersByPost() {
		return CommercialOffersByPost;
	}

	public void setCommercialOffersByPost(Boolean commercialOffersByPost) {
		CommercialOffersByPost = commercialOffersByPost;
	}

	public String getSignature() {
		return Signature;
	}

	public void setSignature(String signature) {
		Signature = signature;
	}

	public Date getCreatedAt() {
		return CreatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}
	
}
