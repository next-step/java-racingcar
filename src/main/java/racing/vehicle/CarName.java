package racing.vehicle;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private String name;

    public CarName(String carName) {
        validateCarName(carName);
        this.name = carName;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CarName)) {
            return false;
        }
        CarName carName = (CarName) obj;
        return this.name.equals(carName.name);
    }

    private void validateCarName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Car name must be non-blank value");
        }

        if (name.length() > CAR_NAME_MAX_LENGTH) {
            String exceptionMessage = String.format(
                    "Car name must be at most %s characters long.", CAR_NAME_MAX_LENGTH);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
