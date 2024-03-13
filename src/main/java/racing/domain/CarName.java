package racing.domain;

public class CarName {
    private static final int NAME_LENGTH_MAX = 5;

    private final String value;

    public CarName(String name) {
        if (isNullOrBlank(name)) {
            throw new IllegalArgumentException();
        }
        
        if (isMoreThanMaxLength(name)) {
            throw new IllegalArgumentException();
        }
        
        this.value = name;
    }

    public String value() {
        return value;
    }

    private boolean isMoreThanMaxLength(String name) {
        return name.length() > NAME_LENGTH_MAX;
    }

    private boolean isNullOrBlank(String name) {
        return name == null || name.isBlank();
    }
}
