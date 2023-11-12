package racingcar.domain;

public class Name {
    private static final int STANDARD_CAR_NAME_LENGTH = 5;

    private String name;

    public Name(String name) {
        if (name.length() > STANDARD_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(String
                    .format("Input Car name : %s, car name must be less than 6 characters.", name));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
