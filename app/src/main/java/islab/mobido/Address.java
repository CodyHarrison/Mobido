
package islab.mobido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Address {

    private String use;
    private String type;
    private List<String> line = null;
    private String city;
    private String district;
    private String state;
    private String postalCode;
    private Period_ period;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getLine() {
        return line;
    }

    public void setLine(List<String> line) {
        this.line = line;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Period_ getPeriod() {
        return period;
    }

    public void setPeriod(Period_ period) {
        this.period = period;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
