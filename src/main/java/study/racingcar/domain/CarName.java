package study.racingcar.domain;

public class CarName {

    public static final int MAX_CAR_NAME_LENGTH = 5;
    private final String value;

    public CarName(String value) {
        validateCarName(value);
        this.value = value;
    }
    private void validateCarName(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
    @Override
    public String toString() {
        return value;
    }
}
