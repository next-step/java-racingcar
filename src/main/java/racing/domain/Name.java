package racing.domain;

public class Name {

    public static final int MAX_LENGTH = 5;
    public static final int ZERO = 0;
    private final String name;

    public Name(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name is empty.");
        }
        this.name = substringMaxLength(name);
    }

    private String substringMaxLength(String name) {
        if (name.length() > MAX_LENGTH) {
            return name.substring(ZERO, MAX_LENGTH);
        }
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
