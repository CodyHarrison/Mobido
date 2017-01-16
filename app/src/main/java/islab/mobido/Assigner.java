
package islab.mobido;

import java.util.HashMap;
import java.util.Map;

public class Assigner {

    private String display;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
