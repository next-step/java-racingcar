package racinggamewinner.domain;

public class CarName {
    public static final int CARNAME_MAX_LENGTH = 5;
    private String carName;

    public CarName(String carName) {
        this.carName = carName;
    }

    public String carNameString() {
        return carName;
    }

    public void checkNameLength() {
        if (carName.length() > CARNAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
