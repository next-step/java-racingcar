package racingcar.strategy;

public class MovableNumberGeneratorStrategy implements NumberGeneratorStrategy {

    public static final int MOVABLE_CONDITION = 4;

    @Override
    public int generateNumber() {
        return MOVABLE_CONDITION;
    }
}
