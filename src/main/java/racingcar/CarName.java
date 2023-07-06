package racingcar;

public class CarName {

    private final String name;

    public CarName(String name) {
        if(isNotValid(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getCarName() {
        return name;
    }

    private boolean isNotValid(String carName) {
        return (carName == null || carName.length() > 5);
    }
}
