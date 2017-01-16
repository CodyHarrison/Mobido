
package islab.mobido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Name {

    private List<String> fhirComments = null;
    private String use;
    private List<String> family = null;
    private List<String> given = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<String> getFhirComments() {
        return fhirComments;
    }

    public void setFhirComments(List<String> fhirComments) {
        this.fhirComments = fhirComments;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public List<String> getFamily() {
        return family;
    }

    public void setFamily(List<String> family) {
        this.family = family;
    }

    public List<String> getGiven() {
        return given;
    }

    public void setGiven(List<String> given) {
        this.given = given;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
