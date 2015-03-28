package com.paymentreminder.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author lalit_bist
 *
 */
@Entity
@Table(name = "user", catalog = "payment_assitant_db", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class UserModel implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6289192753410397857L;
	private Integer userId;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String phone;
	private String address1;
	private String address2;
	private String city;
	private String stateOrProvince;
	private String zipcode;
	private String usercol;
	private String userType;
	
	private String password;
	private Date createdOn;
	private Date updatedOn;
	private String createdBy;
	private String updatedBy;
	private Set<Reminder> reminders;
	private Set<PaymentCards> paymentCardses;

	public UserModel() {
	}

	public UserModel(String firstName, String username, String email,
			String userType, String password, Date createdOn, String createdBy) {
		this.firstName = firstName;
		this.username = username;
		this.email = email;
		this.userType = userType;
		this.password = password;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}

	public UserModel(String firstName, String lastName, String username,
			String email, String phone, String address1, String address2,
			String city, String stateOrProvince, String zipcode,
			String usercol, String userType, String password, Date createdOn,
			Date updatedOn, String createdBy, String updatedBy, Set<Reminder> reminders,
			Set<PaymentCards> paymentCardses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.stateOrProvince = stateOrProvince;
		this.zipcode = zipcode;
		this.usercol = usercol;
		this.userType = userType;
		this.password = password;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.reminders = reminders;
		this.paymentCardses = paymentCardses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "first_name", nullable = false, length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email", unique = true, nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address1", length = 45)
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "address2", length = 45)
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "city", length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state_or_province", length = 45)
	public String getStateOrProvince() {
		return this.stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	@Column(name = "zipcode", length = 45)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "usercol", length = 45)
	public String getUsercol() {
		return this.usercol;
	}

	public void setUsercol(String usercol) {
		this.usercol = usercol;
	}

	@Column(name = "user_type", nullable = false, length = 45)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@JsonIgnore
	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false, length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on", length = 19)
	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Column(name = "created_by", nullable = false, length = 45)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "updated_by", length = 45)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Reminder> getReminders() {
		return this.reminders;
	}

	@JsonProperty
	public void setReminders(Set<Reminder> reminders) {
		this.reminders = reminders;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<PaymentCards> getPaymentCardses() {
		return this.paymentCardses;
	}

	@JsonProperty
	public void setPaymentCardses(Set<PaymentCards> paymentCardses) {
		this.paymentCardses = paymentCardses;
	}

}
