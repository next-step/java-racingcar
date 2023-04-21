package study.racingcar.domain;

public class CarName {
    public static final int MAX_CAR_NAME_LENGTH = 5;
    private final String value;

    public CarName(String value) {
        validateCarName(value.trim());
        this.value = value;
    }

    private void validateCarName(String carName) {
        validateEmptyString(carName);
        validateIfExceedingMaxLength(carName);
    }

    private void validateIfExceedingMaxLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void validateEmptyString(String carName) {
        if (carName.length() == 0) {
            throw new IllegalArgumentException("이름은 한 글자 이상으로 입력해 주세요.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
