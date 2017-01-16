
package islab.mobido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Telecom {

    private List<String> fhirComments = null;
    private String use;
    private String system;
    private String value;
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

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
