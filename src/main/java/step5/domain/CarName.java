package step5.domain;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private String name;

    public CarName(String name) {
        if (isOverLength(name)) this.name = name;
    }

    public String getName() {
        return name;
    }

    private boolean isOverLength(String name) {
        if (name == null || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
