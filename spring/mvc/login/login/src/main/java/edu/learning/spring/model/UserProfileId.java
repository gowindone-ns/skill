package edu.learning.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Generated Feb 24, 2014 7:30:55 PM by Hibernate Tools 3.4.0.CR1

/**
 * UserProfileId generated by hbm2java
 */
@Entity
@Table(name = "user_profile", schema = "APP")
public class UserProfileId implements java.io.Serializable {

	private String name;
	private String password;

	public UserProfileId() {
	}

	public UserProfileId(String name, String password) {
		this.name = name;
		this.password = password;
	}

	@Column(unique = true,length=20)
	@Id
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserProfileId))
			return false;
		UserProfileId castOther = (UserProfileId) other;

		return ((this.getName() == castOther.getName()) || (this.getName() != null
				&& castOther.getName() != null && this.getName().equals(
				castOther.getName())))
				&& ((this.getPassword() == castOther.getPassword()) || (this
						.getPassword() != null
						&& castOther.getPassword() != null && this
						.getPassword().equals(castOther.getPassword())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getPassword() == null ? 0 : this.getPassword().hashCode());
		return result;
	}

}
