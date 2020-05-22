package game.domain;

public class CarName {
    private final String name;

    public CarName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name must not be null or empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
