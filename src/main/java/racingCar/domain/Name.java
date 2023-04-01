package racingCar.domain;

public class Name {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private final String value;

    public Name(final String value) {

        if (value.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은" + CAR_NAME_MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
