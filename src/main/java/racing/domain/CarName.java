package racing.domain;

public class CarName {
    private final int MAX_USER_NAME_LENGTH = 5;
    private final String carName;

    public CarName(String carName) {
        validateCarNameLength(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validateCarNameLength(String userName) {
        if (userName.length() > MAX_USER_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}


