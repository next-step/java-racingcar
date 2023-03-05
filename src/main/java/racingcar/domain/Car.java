package racingcar.domain;

import static racingcar.utility.VerificationUtility.validateCarName;

public class Car {
    private static final int VALUE = 0;
    private static final int CONDITION_VALUE = 4;

    private final String name;
    private int position = VALUE;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void progress(int number) {
        if (number >= CONDITION_VALUE) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        if (this.position == position) {
            return true;
        }
        return false;
    }
}
