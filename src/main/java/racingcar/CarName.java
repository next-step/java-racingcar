package racingcar;

public class CarName {
    private final int MAX_NAME_LENGTH = 5;
    private final int MIN_NAME_LENGTH = 1;

    private String name;

    public String getName() {
        return name;
    }

    public CarName(String name) {
        validateCarNameLength(name);
        this.name = name;
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH || carName.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
