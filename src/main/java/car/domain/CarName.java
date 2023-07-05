package car.domain;

public final class CarName {

    private String name;
    private final int CAR_NAME_LENGTH_LOWER_BOUND = 5;

    CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LOWER_BOUND) {
            throw new RuntimeException();
        }
    }

    public String getName() {
        return name;
    }
}
