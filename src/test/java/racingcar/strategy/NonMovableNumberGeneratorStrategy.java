package racingcar.strategy;

public class NonMovableNumberGeneratorStrategy implements NumberGeneratorStrategy {

    public static final int NON_MOVABLE_CONDITION = 3;
    public static final int MOVABLE_NUMBER_CONDITION = 4;

    @Override
    public int generateNumber() {
        return NON_MOVABLE_CONDITION;
    }

    @Override
    public boolean isMovable(int number) {
        return number >= MOVABLE_NUMBER_CONDITION;
    }
}
