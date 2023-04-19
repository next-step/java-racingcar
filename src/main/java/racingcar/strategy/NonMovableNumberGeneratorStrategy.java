package racingcar.strategy;

public class NonMovableNumberGeneratorStrategy implements NumberGeneratorStrategy {

    public static final int NON_MOVABLE_CONDITION = 3;

    @Override
    public int generateNumber() {
        return NON_MOVABLE_CONDITION;
    }
}
