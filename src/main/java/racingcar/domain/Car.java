package racingcar.domain;

import java.util.InputMismatchException;

public class Car {

    public static final int INITIAL_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        checkNameLength(name);

        this.position = INITIAL_POSITION;
        this.name = name;
    }


    private static void checkNameLength(String name) {
        if (isNameOverMaxLength(name))
            throw new InputMismatchException("MAX NAME LENGTH: " + MAX_NAME_LENGTH + ", NAME: " + name);
    }

    private static boolean isNameOverMaxLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    public void move(RuleStrategy ruleStrategy) {
        position += ruleStrategy.getMovement();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
