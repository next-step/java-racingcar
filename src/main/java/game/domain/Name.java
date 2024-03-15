package game.domain;

public class Name {
    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || "".equals(name) || name.length() > 5) {
            throw new RuntimeException();
        }
    }

    public String getName(){
        return this.name;
    }
}
