package racingcar.domain;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        if(isNotValid(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isNotValid(String carName) {
        return (carName == null || carName.length() > MAX_LENGTH);
    }
}
