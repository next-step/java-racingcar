package racingcar;

public class CarName {

    private final String carName;

    public CarName(String carName) {
        isValid(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private void isValid(String carName) {
        if (carName == null || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
