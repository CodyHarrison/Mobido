
package islab.mobido;

import java.util.HashMap;
import java.util.Map;

public class Period_ {

    private String start;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
