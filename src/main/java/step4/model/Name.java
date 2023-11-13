package step4.model;

public class Name {

    private final String name;

    public Name(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
