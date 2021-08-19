package car.domain;

public final class CarName {
    private final int MAX_SIZE_NAME_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        validateCarName(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void validateCarName(String carName) {
        if (carName.length() > MAX_SIZE_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_SIZE_NAME_LENGTH + "자를 초과할 수 없습니다.");
        }
    }
}
