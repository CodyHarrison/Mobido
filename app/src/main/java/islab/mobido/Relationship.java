
package islab.mobido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Relationship {

    private List<Coding_> coding = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Coding_> getCoding() {
        return coding;
    }

    public void setCoding(List<Coding_> coding) {
        this.coding = coding;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
