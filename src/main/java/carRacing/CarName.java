package carRacing;

public class CarName {
    public static final int MAX_NAME_SIZE = 5;
    private String value;

    public CarName(String value) {
        carNameLengthCheck(value);
        this.value = value;
    }

    private void carNameLengthCheck(String value) {
        if (value.length() > MAX_NAME_SIZE) {
            throw new RuntimeException();
        }
    }

    public String getValue() {
        return value;
    }
}
