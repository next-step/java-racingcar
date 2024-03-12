package racinggame.domain;

public class CarName {

    private static final int MAXIMUM_NAME_SIZE = 5;

    private String value;

    public CarName(String carName) {
        validNameSize(carName);
        this.value = carName;
    }

    private void validNameSize(String carName) {
        if (carName.length() > MAXIMUM_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다: " + carName.length());
        }
    }

    public String value() {
        return value;
    }
}
