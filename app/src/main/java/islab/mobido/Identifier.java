
package islab.mobido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Identifier {

    private List<String> fhirComments = null;
    private String use;
    private Type type;
    private String system;
    private String value;
    private Period period;
    private Assigner assigner;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Assigner getAssigner() {
        return assigner;
    }

    public void setAssigner(Assigner assigner) {
        this.assigner = assigner;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
