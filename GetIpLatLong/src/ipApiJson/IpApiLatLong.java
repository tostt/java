
package ipApiJson;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class IpApiLatLong {

    @Expose
    private String as;
    @Expose
    private String city;
    @Expose
    private String country;
    @Expose
    private String countryCode;
    @Expose
    private String isp;
    @Expose
    private Double lat;
    @Expose
    private Double lon;
    @Expose
    private String org;
    @Expose
    private String query;
    @Expose
    private String region;
    @Expose
    private String regionName;
    @Expose
    private String status;
    @Expose
    private String timezone;
    @Expose
    private String zip;

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

    public String getQuery() {
        return query;
    }

    public String getRegion() {
        return region;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getStatus() {
        return status;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

}
