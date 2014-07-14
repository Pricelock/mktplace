package com.pl.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String email;

	@Column(nullable=true)
	private Integer age;

	@Column(name = "creation_time", nullable = false)
    private Date creationTime;
	
	@Column(name = "modification_time", nullable = false)
    private Date modificationTime;
	
	@Version
    private long version = 0;
	
	public static Builder getBuilder(String firstName, String lastName) {
		return new Builder(firstName,lastName);
	}
	
	@PreUpdate
    public void preUpdate() {
        modificationTime = new Date();
    }
     
    @PrePersist
    public void prePersist() {
        Date now = new Date();
        creationTime = now;
        modificationTime = now;
    }
 
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
	
	/**
     * Gets the full name of the person.
     * @return  The full name of the person.
     */
    @Transient
    public String getName() {
        StringBuilder name = new StringBuilder();
         
        name.append(firstName);
        name.append(" ");
        name.append(lastName);
         
        return name.toString();
    }
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}


	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}


	/**
	 * @return the modificationTime
	 */
	public Date getModificationTime() {
		return modificationTime;
	}


	/**
	 * @return the version
	 */
	public long getVersion() {
		return version;
	}


	/**
     * A Builder class used to create new Person objects.
     */
    public static class Builder {
        User built;
 
        /**
         * Creates a new Builder instance.
         * @param firstName The first name of the created Person object.
         * @param lastName  The last name of the created Person object.
         */
        Builder(String firstName, String lastName) {
            built = new User();
            built.firstName = firstName;
            built.lastName = lastName;
        }
 
        /**
         * Builds the new Person object.
         * @return  The created Person object.
         */
        public User build() {
            return built;
        }
    }
    
    /**
     * This setter method should only be used by unit tests.
     * @param id
     */
    protected void setId(Long id) {
        this.id = id;
    }

}
