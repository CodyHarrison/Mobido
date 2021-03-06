
package islab.mobido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BirthDateInfo {

    private List<Extension> extension = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Extension> getExtension() {
        return extension;
    }

    public void setExtension(List<Extension> extension) {
        this.extension = extension;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
