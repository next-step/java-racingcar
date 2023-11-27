package study.race.model;

public class Name {

    private final int CAR_NAME_LENGTH_LIMIT = 5;

    private String name;

    public Name(String name) {
        checkOverLength(name);
        this.name = name;
    }

    private void checkOverLength(String name) {
        if (name.length() > CAR_NAME_LENGTH_LIMIT)
            throw new IllegalArgumentException("String length exceeds the allowed maximum(5).");
    }

    public String getName() {
        return this.name;
    }
}
