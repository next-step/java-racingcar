package racing.domain;

public class CarName {
    private static final int MAX_USER_NAME_LENGTH = 5;
    private final String value;

    public CarName(String carName) {
        validateCarNameLength(carName);
        this.value = carName;
    }

    public String getCarName() {
        return value;
    }

    private void validateCarNameLength(String userName) {
        if (userName.length() > MAX_USER_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}


