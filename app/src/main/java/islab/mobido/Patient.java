
package islab.mobido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Patient {

    private String resourceType;
    private int id;
    private Text text;
    private List<Identifier> identifier = null;
    private boolean active;
    private List<Name> name = null;
    private List<Telecom> telecom = null;
    private String gender;
    private GenderInfo genderInfo;
    private String birthDate;
    private BirthDateInfo birthDateInfo;
    private boolean deceasedBoolean;
    private List<Address> address = null;
    private List<Contact> contact = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public List<Identifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<Identifier> identifier) {
        this.identifier = identifier;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Name> getName() {
        return name;
    }

    public void setName(List<Name> name) {
        this.name = name;
    }

    public List<Telecom> getTelecom() {
        return telecom;
    }

    public void setTelecom(List<Telecom> telecom) {
        this.telecom = telecom;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public GenderInfo getGenderInfo() {
        return genderInfo;
    }

    public void setGenderInfo(GenderInfo genderInfo) {
        this.genderInfo = genderInfo;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public BirthDateInfo getBirthDateInfo() {
        return birthDateInfo;
    }

    public void setBirthDateInfo(BirthDateInfo birthDateInfo) {
        this.birthDateInfo = birthDateInfo;
    }

    public boolean isDeceasedBoolean() {
        return deceasedBoolean;
    }

    public void setDeceasedBoolean(boolean deceasedBoolean) {
        this.deceasedBoolean = deceasedBoolean;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
