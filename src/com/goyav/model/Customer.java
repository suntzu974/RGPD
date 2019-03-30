package com.goyav.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "customer")
@XmlAccessorType (XmlAccessType.FIELD)
public class Customer {
	@SerializedName("reference")
	private String Reference;
	@SerializedName("name")
	private String Name;
	@SerializedName("raison")
	private String Raison;
	@SerializedName("sigle")
	private String Sigle;
	@SerializedName("identity")
	private String Identity;
	@SerializedName("street")
	private String Street;
	@SerializedName("address")
	private String Address;
	@SerializedName("postcod")
	private String Postcod;
	@SerializedName("town")
	private String Town;
	@SerializedName("country")
	private String Country;
	@SerializedName("phone")
	private String Phone;
	@SerializedName("email")
	private String Email;

   public Customer() {}
   
   public Customer(String _reference, String _name, String _raison,
			String _sigle, String _identity, String _street, String _address,
			String _postcod, String _town, String _country, String _phone, String  _email) 
	{
	   	this.Reference = _reference;
		this.Name = _name;
		this.Raison = _raison;
		this.Sigle = _sigle;
		this.Identity = _identity;
		this.Street = _street;
		this.Address  = _address;
		this.Postcod = _postcod;
		this.Town = _town;
		this.Country = _country;
		this.Phone  = _phone;
		this.Email = _email;
			   
		 
	   }
	 
		public String getReference() {
			return Reference;
		}

		public void setReference(String reference) {
			Reference = reference;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public String getRaison() {
			return Raison;
		}

		public void setRaison(String raison) {
			Raison = raison;
		}

		public String getSigle() {
			return Sigle;
		}

		public void setSigle(String sigle) {
			Sigle = sigle;
		}

		public String getIdentity() {
			return Identity;
		}

		public void setIdentity(String identity) {
			Identity = identity;
		}

		public String getStreet() {
			return Street;
		}

		public void setStreet(String street) {
			Street = street;
		}

		public String getAddress() {
			return Address;
		}

		public void setAddress(String address) {
			Address = address;
		}

		public String getPostcod() {
			return Postcod;
		}

		public void setPostcod(String postcod) {
			Postcod = postcod;
		}

		public String getTown() {
			return Town;
		}

		public void setTown(String town) {
			Town = town;
		}

		public String getCountry() {
			return Country;
		}

		public void setCountry(String country) {
			Country = country;
		}

		public String getPhone() {
			return Phone;
		}

		public void setPhone(String phone) {
			Phone = phone;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

}