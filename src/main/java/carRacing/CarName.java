package carRacing;

public class CarName {
    private String value;

    public CarName(String value) {
        carNameLengthCheck(value);
        this.value = value;
    }

    private void carNameLengthCheck(String value) {
        if (value.length() > 5) {
            throw new RuntimeException();
        }
    }

    public String getValue() {
        return value;
    }
}
