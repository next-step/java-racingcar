package study.racing.model;

public class Name {

    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public boolean longerThan(int length) {
        return name.length() > length;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
