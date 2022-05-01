package racingcarwinnerrefactor.domain;

import racingcarwinnerrefactor.exception.NameSizeException;

public class Name {
    private final String name;
    private static final int MAX_LENGTH = 5;

    public Name(String name) {
        assertNameSize(name);
        this.name = name;
    }

    private void assertNameSize(String name) {
        if(name.length() > MAX_LENGTH)   throw new NameSizeException();
    }

    @Override
    public String toString() {
        return name;
    }
}
