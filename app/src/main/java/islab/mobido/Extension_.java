
package islab.mobido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Extension_ {

    private List<String> fhirComments = null;
    private String url;
    private String valueCode;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<String> getFhirComments() {
        return fhirComments;
    }

    public void setFhirComments(List<String> fhirComments) {
        this.fhirComments = fhirComments;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
