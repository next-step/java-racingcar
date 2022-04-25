package racing;

public class CarName {
    private static final int MAX_NAME_SIZE = 5;
    String name;

    public CarName(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
