package racinggame.domain;

import racinggame.domain.exception.InputIsBlankException;
import racinggame.domain.exception.InputOverFiveLengthException;

public class CarName {

    public static final int MAX_LENGTH = 5;
    private String name;

    public CarName(String name) {
        if (isBlank(name)) {
            throw new InputIsBlankException();
        }
        if (isOverFiveLength(name)) {
            throw new InputOverFiveLengthException();
        }
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private boolean isOverFiveLength(String name) {
        return name.length() > MAX_LENGTH;
    }
}
