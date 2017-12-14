package Deal;

public class Party {
    private String name;
    private String address;
    private String[] keys;
    private String[] values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getKeys() {
        return keys;
    }

    public String[] getValues() {
        return values;
    }

    public void setKeys(String[] keys) {
        this.keys = keys;
    }

    public void setValues(String[] values) {
        this.values = values;
    }
}
