package step3.domain;

public class CarName {

    private final String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("이름은 한글자 이상 입력해야합니다.");
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력가능합니다.");
        }
    }

    public String value() {
        return value;
    }

}
