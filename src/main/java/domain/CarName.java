package domain;

public class CarName {
    private static final int CAR_NAME_LENGTH = 5;

    private final String name;

    private CarName(String name) {
        if (name.length() > CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("CarName can not over length 5");
        }
        this.name = name;
    }

    public static CarName create(String carNameString) {
        return new CarName(carNameString);
    }

    public String name() {
        return name;
    }
}
