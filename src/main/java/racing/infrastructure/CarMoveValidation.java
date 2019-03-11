package racing.infrastructure;

import racing.application.Validation;

import java.util.Random;

public class CarMoveValidation implements Validation {
    private final int BOUND = 9;
    private final int CONDITION = 4;

    @Override
    public boolean check() {
        return new Random().nextInt(BOUND) >= CONDITION;
    }
}
