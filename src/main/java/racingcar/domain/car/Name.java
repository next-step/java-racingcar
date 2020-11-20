package racingcar.domain.car;

public class Name {

    private static final int LIMIT_LENGTH = 5;
    private static final String BLANK = "";
    private static final String BLANK_NAME = " ";
    private final String value;

    public Name(String value) {
        validName(value);
        this.value = value;
    }

    private void validName(String value) {
        if (value.equals(BLANK) || value.equals(BLANK_NAME)) {
            throw new IllegalArgumentException("the name must not blank.");
        }
        if (value.length() > LIMIT_LENGTH) {
            throw new IllegalArgumentException("the name must be less than five characters.");
        }
    }

    public String getValue() {
        return value;
    }
}
