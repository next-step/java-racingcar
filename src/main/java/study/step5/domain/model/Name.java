package study.step5.domain.model;

import study.step5.exception.CustomException;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;

    String name;

    public Name(String name) {
        checkName(name);
        this.name = name;
    }

    private void checkName(String name) {
        if (name.length() > CustomException.NAME_MAX_LENGTH.getLength()) {
            throw new IllegalArgumentException(CustomException.NAME_MAX_LENGTH.getMessage());
        }
    }

    public String getName() {
        return name;
    }

}
