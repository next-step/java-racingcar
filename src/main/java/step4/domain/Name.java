package step4.domain;

public class Name {
    private String name;

    private final static int MIN_LENGTH = 1;
    private final static int MAX_LENGTH = 5;


    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_LENGTH || name.length() < MIN_LENGTH) {
            throw new StringIndexOutOfBoundsException();
        }
    }
    public String name() {
        return this.name;
    }
}
