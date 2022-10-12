package domain;

public class CarName {

    private static final Integer MAX_CAR_NAME_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        if (!validName(carName)) {
            throw new IllegalArgumentException(carName + "자동차 이름은 빈값이거나 5자를 초과할 수 없습니다.");
        }
        this.carName = carName;
    }

    private boolean validName(String carName) {
        return carName != null && !carName.trim().isEmpty() && carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    public String getCarName() {
        return this.carName;
    }
}
