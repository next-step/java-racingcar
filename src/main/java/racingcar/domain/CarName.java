package racingcar.domain;

public class CarName {
    private final String name;

    public CarName(String name) {
        if(name.isBlank() || name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("name length must be between 1 and 5");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}
