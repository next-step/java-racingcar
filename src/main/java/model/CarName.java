package model;

public final class CarName {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        if (isInvalid(name)) {
            throw new IllegalArgumentException(name);
        }
        this.name = name;
    }

    private boolean isInvalid(String name) {
        return name == null || name.isBlank() || name.length() > MAX_CAR_NAME_LENGTH;
    }

    public String getName() {
        return name;
    }

}
