package com.vcabading.projectmanager.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/////////////////////////////////////////////////////////////
//	USER CLASS
/////////////////////////////////////////////////////////////

@Entity
@Table(name="users")
public class User {

	//	//// FIELDS /////////////////////////////////////////
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Pattern(regexp="^[A-Za-z]*$",message = "User Name must be letters only")		// Validate: Alphabet Only
    @NotNull
    @NotEmpty(message="First Name is required!")
    @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
    private String firstName;
    
    @Pattern(regexp="^[A-Za-z]*$",message = "User Name must be letters only")		// Validate: Alphabet Only
    
    @NotNull
    @NotEmpty(message="Last name is required!")
    @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
    private String lastName;
    
    @NotNull
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    @NotNull
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
    
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;

    //	---- ONE:TO:MANY RELATIONSHIP --------------------------    
    @OneToMany(mappedBy="leader", fetch = FetchType.LAZY)
    private List<Project> projectsList;

	@Column(updatable=false)		// this will not allow createdAt to be updated after creation
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate()	{
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
  
	//	//// CONSTRUCTOR ////////////////////////////////////
	
    public User() {}
    
    public User(String firstName, String lastName, String email, String password) {
    	super();
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.password = password;
    }
    
    //	//// GETTERS AND SETTERS ////////////////////////////


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Project> getProjectsList() {
		return projectsList;
	}

	public void setProjectsList(List<Project> projectsList) {
		this.projectsList = projectsList;
	}
    
    
}