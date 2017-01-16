
package islab.mobido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenderInfo {

    private List<String> fhirComments = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<String> getFhirComments() {
        return fhirComments;
    }

    public void setFhirComments(List<String> fhirComments) {
        this.fhirComments = fhirComments;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
