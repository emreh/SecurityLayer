package owl.my.firend.persistence.model.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserPermission implements Serializable {

	private static final long serialVersionUID = 5953654624639802767L;

	private BigDecimal id;

	private String permission;

	private List<UserDetails> userDetails = new ArrayList<>();

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public List<UserDetails> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(List<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "UserPermission [id=" + id + ", permission=" + permission + ", userDetails=" + userDetails + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((permission == null) ? 0 : permission.hashCode());
		result = prime * result + ((userDetails == null) ? 0 : userDetails.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPermission other = (UserPermission) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (permission == null) {
			if (other.permission != null)
				return false;
		} else if (!permission.equals(other.permission))
			return false;
		if (userDetails == null) {
			if (other.userDetails != null)
				return false;
		} else if (!userDetails.equals(other.userDetails))
			return false;
		return true;
	}
}