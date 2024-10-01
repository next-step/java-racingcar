package carracing.domain;

import carracing.exception.RacingCarIllegalArgumentException;
import util.StringUtil;

public class Car {
    private static final int ALLOWED_MAXIMUM_NAME_LENGTH = 5;
    private static final int DEFAULT_POSITION = 1;
    private static final int ALLOWED_MINIMUM_DISTANCE = 4;

    private final String name;
    private int position;

    private Car(String name) {
        this.position = DEFAULT_POSITION;
        this.name = name;
    }

    public static Car of(String name) {
        if (StringUtil.isBlank(name) || name.length() > ALLOWED_MAXIMUM_NAME_LENGTH) {
            throw RacingCarIllegalArgumentException.INVALID_NAME_LENGTH;
        }
        return new Car(name);
    }

    public void move(int randomNumber) {
        if (canMove(randomNumber)) {
            position++;
        }
    }

    private boolean canMove(int distance) {
        return distance >= ALLOWED_MINIMUM_DISTANCE;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }


}
