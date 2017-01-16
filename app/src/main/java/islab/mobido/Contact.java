
package islab.mobido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contact {

    private List<Relationship> relationship = null;
    private Name_ name;
    private List<Telecom_> telecom = null;
    private String gender;
    private Period__ period;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Relationship> getRelationship() {
        return relationship;
    }

    public void setRelationship(List<Relationship> relationship) {
        this.relationship = relationship;
    }

    public Name_ getName() {
        return name;
    }

    public void setName(Name_ name) {
        this.name = name;
    }

    public List<Telecom_> getTelecom() {
        return telecom;
    }

    public void setTelecom(List<Telecom_> telecom) {
        this.telecom = telecom;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Period__ getPeriod() {
        return period;
    }

    public void setPeriod(Period__ period) {
        this.period = period;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
