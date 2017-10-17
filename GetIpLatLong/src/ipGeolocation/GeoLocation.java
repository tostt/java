package ipGeolocation;

import ipApiJson.IpApiLatLong;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Input: None Output: IP adress, Latitude, Longitude, etc.
 * 
 * @author mcontens
 *
 */
public class GeoLocation {

	private static final String URL_BASE = "http://ip-api.com/json";

	private String query;
	private String status;
	private String as;
	private String city;
	private String country;
	private String countryCode;
	private String isp;
	private Double lat;
	private Double lon;
	private String org;
	private String region;
	private String regionName;
	private String timezone;
	private String zip;

	public String getQuery() {
		return query;
	}

	public String getStatus() {
		return status;
	}

	public static String getUrlBase() {
		return URL_BASE;
	}

	public String getAs() {
		return as;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getIsp() {
		return isp;
	}

	public Double getLat() {
		return lat;
	}

	public Double getLon() {
		return lon;
	}

	public String getOrg() {
		return org;
	}

	public String getRegion() {
		return region;
	}

	public String getRegionName() {
		return regionName;
	}

	public String getTimezone() {
		return timezone;
	}

	public String getZip() {
		return zip;
	}

	public GeoLocation() {

		String url = URL_BASE;

		InputStream source = retrieveStream(url);
		Gson gson = new Gson();
		Reader reader = null;
		try {
			reader = new InputStreamReader(source, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();

		}
		IpApiLatLong ill = gson.fromJson(reader, IpApiLatLong.class);
		status = ill.getStatus().trim();

		if (status.equals("success")) {
			as = ill.getAs().trim();
			city = ill.getCity().trim();
			country = ill.getCountry().trim();
			countryCode = ill.getCountryCode().trim();
			isp = ill.getIsp().trim();
			lat = ill.getLat();
			lon = ill.getLon();
			org = ill.getOrg().trim();
			query = ill.getQuery().trim();
			region = ill.getRegion().trim();
			regionName = ill.getRegionName().trim();
			timezone = ill.getTimezone().trim();
			zip = ill.getZip().trim();
		}

	}

	private static InputStream retrieveStream(String url) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(url);
		try {
			HttpResponse getResponse = client.execute(getRequest);
			final int statusCode = getResponse.getStatusLine().getStatusCode();

			if (statusCode != HttpStatus.SC_OK) {
				System.out.println("Error " + statusCode + " for URL " + url);
				return null;
			}
			HttpEntity getResponseEntity = getResponse.getEntity();
			return getResponseEntity.getContent();
		} catch (IOException e) {
			getRequest.abort();
			System.out.println("Error for URL " + url);
		}
		return null;
	}

	public static void main(String[] args) {

		GeoLocation ill = new GeoLocation();

		System.out.println("IP Q         " + ill.getQuery());
		System.out.println("Status       " + ill.getStatus());
		System.out.println("As           " + ill.getAs());
		System.out.println("City         " + ill.getCity());
		System.out.println("Country      " + ill.getCountry());
		System.out.println("Country code " + ill.getCountryCode());
		System.out.println("ISP          " + ill.getIsp());
		System.out.println("Latitude     " + ill.getLat());
		System.out.println("Longitude    " + ill.getLon());
		System.out.println("Org          " + ill.getOrg());
		System.out.println("Region       " + ill.getRegion());
		System.out.println("Region Name  " + ill.getRegionName());
		System.out.println("Timezone     " + ill.getTimezone());
		System.out.println("Zip          >" + ill.getZip()+"<");

	}
}
