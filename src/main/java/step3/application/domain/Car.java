package step3.application.domain;

import error.ErrorMessage;
import step3.application.domain.model.MovementLog;

public class Car {

    private final String name;
    private int location;
    public static final int INIT_LOCATION = 0;

    public Car(String name) {
        this(name, INIT_LOCATION);
    }

    public Car(String  name, int position) {
        validateName(name);
        this.name = name;
        this.location = position;
    }

    private void validateName(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.ERR_INVALID_NUMBER.print());
        }
    }

    public MovementLog move(boolean isMovable) {
        if (isMovable) {
            this.location += 1;
        }
        return new MovementLog(this.name, this.location);
    }
}