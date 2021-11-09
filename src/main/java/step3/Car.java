package step3;

public class Car {
    private final int MOVEMENT_MIN_VALUE = 0;
    private final int MOVEMENT_MAX_VALUE = 9;
    private final int RUN_CONDITION_VALUE = 4;

    private Count runPosition;

    public Car() {
        runPosition = new Count();
    }

    public Count currentPosition() {
        return runPosition;
    }

    public void run(int input) {
        isValidBetweenMinMax(input);

        if(input >= RUN_CONDITION_VALUE) {
            runPosition.plusCount();
        }
    }

    private void isValidBetweenMinMax(int input) {
        if(input < MOVEMENT_MIN_VALUE || MOVEMENT_MAX_VALUE < input) {
            throw new IllegalArgumentException(MyException.VALID_VALUE_IS_ZERO_TO_NINE.getMessage());
        }
    }
}
