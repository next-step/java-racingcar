package racinggame.domain;

public class CarName {

    private final String carName;
    private final int MAX_NAME_LENGTH = 5;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과 할 수 없습니다.");
        }
    }

    public String getCarName() {
        return carName;
    }
}
