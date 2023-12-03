package com.qsp.hotelmanagementsystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
public class Admin {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int admin_id;
@NotNull(message = "admin name cannot be null")
@NotBlank(message = "admn name cannot be blank"	)
	private String admin_name;
@NotNull(message = "admin email cannot be null")
@NotBlank(message = "admin email cannot be blank"	)
@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",message = "Invalid email")
	private String admin_email;
@NotNull(message = "admin password cannot be null")
@NotBlank(message = "admin password cannot be blank"	)
@Pattern(regexp = "^(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\S+$).{6,}$",message = "min 6 characters mandatory(1 lowerCase ,1 upperCase,1 "
		+ "specialcharacter ,1 Number)")
	private String admin_password;
	
	@OneToOne
	private Hotel hotel;

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_email() {
		return admin_email;
	}

	public void setAdmin_email(String admin_email) {
		this.admin_email = admin_email;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
}
