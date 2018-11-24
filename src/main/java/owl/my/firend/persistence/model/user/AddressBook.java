package owl.my.firend.persistence.model.user;

import java.io.Serializable;
import java.math.BigDecimal;

//import org.hibernate.annotations.GenericGenerator;

import owl.my.firend.persistence.util.type.user.AddressDefine;

public class AddressBook implements Serializable {

	private static final long serialVersionUID = 4556071415521639623L;

	private BigDecimal id;

	private String country;

	private String city;

	private String district;

	private String street;

	private String alley;

	private Integer plate;

	private Integer floor;

	private Integer unit;

	private AddressDefine addressDefineType;

	private UserDetails userDetails;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAlley() {
		return alley;
	}

	public void setAlley(String alley) {
		this.alley = alley;
	}

	public Integer getPlate() {
		return plate;
	}

	public void setPlate(Integer plate) {
		this.plate = plate;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getUnit() {
		return unit;
	}

	public void setUnit(Integer unit) {
		this.unit = unit;
	}

	public AddressDefine getAddressDefineType() {
		return addressDefineType;
	}

	public void setAddressDefineType(AddressDefine addressDefineType) {
		this.addressDefineType = addressDefineType;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "AddressBook [id=" + id + ", country=" + country + ", city=" + city + ", district=" + district
				+ ", street=" + street + ", alley=" + alley + ", plate=" + plate + ", floor=" + floor + ", unit=" + unit
				+ ", addressDefineType=" + addressDefineType + ", userDetails=" + userDetails + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressDefineType == null) ? 0 : addressDefineType.hashCode());
		result = prime * result + ((alley == null) ? 0 : alley.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((plate == null) ? 0 : plate.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		AddressBook other = (AddressBook) obj;
		if (addressDefineType != other.addressDefineType)
			return false;
		if (alley == null) {
			if (other.alley != null)
				return false;
		} else if (!alley.equals(other.alley))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (plate == null) {
			if (other.plate != null)
				return false;
		} else if (!plate.equals(other.plate))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (userDetails == null) {
			if (other.userDetails != null)
				return false;
		} else if (!userDetails.equals(other.userDetails))
			return false;
		return true;
	}
}