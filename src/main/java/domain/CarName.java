package domain;

public class CarName {
    private final String name;

    private CarName(String name) {
        if (name.length() > 5) {
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
