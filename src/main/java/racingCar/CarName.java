package racingCar;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private String name = "";

    public CarName(final String name) {
        validate(name);

        this.name = name;
    }

    public void validate(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new InvalidCarNameException();
        }
    }

    public String getName() {
        return name;
    }
}
