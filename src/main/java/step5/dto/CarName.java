package step4.dto;

import step4.common.MyException;

public class CarName {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validNameOrThrow(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validNameOrThrow(String name) {
        if(MIN_LENGTH > name.length() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(MyException.INVALID_NAME_LENGTH.getMessage());
        }
    }
}
