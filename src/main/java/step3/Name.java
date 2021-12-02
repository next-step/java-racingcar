package step3;

public class Name {
    private static final int NAME_LENGTH = 5;

    private String value;

    public Name(String value) {
        if (value.length() > NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
