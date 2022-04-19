package step3.model;

public class Name {

    private final String value;

    public Name(String input) {
        validate(input);
        this.value = input;
    }

    private void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (input.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public String getValue() {
        return this.value;
    }
}
