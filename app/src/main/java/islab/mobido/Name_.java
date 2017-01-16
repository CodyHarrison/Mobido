
package islab.mobido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Name_ {

    private List<String> family = null;
    private List<FamilyInfo> familyInfo = null;
    private List<String> given = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<String> getFamily() {
        return family;
    }

    public void setFamily(List<String> family) {
        this.family = family;
    }

    public List<FamilyInfo> getFamilyInfo() {
        return familyInfo;
    }

    public void setFamilyInfo(List<FamilyInfo> familyInfo) {
        this.familyInfo = familyInfo;
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
