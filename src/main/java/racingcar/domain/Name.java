package racingcar.domain;

public class Name {
    private static final int MAX_LENGTH = 5;

    private final String value;

    public Name(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 " + MAX_LENGTH + "이하여야 합니다.");
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
