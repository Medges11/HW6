public class Contact {
    private String name;
    private String value;

    public Contact(String newName, String newValue) {
        name = newName;
        value = newValue;
    }

    public void SetName(String newName) {
        name = newName;
    }

    public String GetName() {
        return name;
    }

    public void SetValue(String newValue) {
        value = newValue;
    }

    public String GetValue() {
        return value;
    }
}
