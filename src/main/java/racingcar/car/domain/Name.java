package racingcar.car.domain;

/**
 * 자동차 이름을 관리하는 객체
 */
public class Name {

    private final String value;
    private static final int MAX_NAME_LENGTH = 5;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    /**
     * 자동차 이름을 검증한다.
     * - 길이가 5 이하여야 한다
     *
     * @param value 검증할 자동차 이름 (ex. pobi)
     */
    private static void validate(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
