package pojoVelib;

// Généré par http://pojo.sodhanalibrary.com/

public class StationVelibSimple {
	private String address;
	private String name;
	private String longitude;
	private String number;
	private String latitude;

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "ClassPojo [address = " + address + ", name = " + name + ", longitude = " + longitude + ", number = "
				+ number + ", latitude = " + latitude + "]";
	}
}
