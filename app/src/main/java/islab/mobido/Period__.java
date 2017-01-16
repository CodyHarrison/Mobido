
package islab.mobido;

import java.util.HashMap;
import java.util.Map;

public class Period__ {

    private String start;
    private StartInfo startInfo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public StartInfo getStartInfo() {
        return startInfo;
    }

    public void setStartInfo(StartInfo startInfo) {
        this.startInfo = startInfo;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
