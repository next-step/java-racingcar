package racingcar.domain;

public class Name {
    private final static int VALID_LENGTH = 5;
    String name;

    public Name(String name) {
        this.name = name;
        validLength();
    }

    public Name(Name name) {
        this.name = name.name;
        validLength();
    }

    public Boolean validLength() {
        if (this.name.length() > VALID_LENGTH) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public String getName() {
        return this.name;
    }
}
