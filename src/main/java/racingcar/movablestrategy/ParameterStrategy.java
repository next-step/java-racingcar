package racingcar.movablestrategy;

public class ParameterStrategy implements MovableStrategy{
    private int moveCondition;
    private int value;

    public ParameterStrategy(int moveCondition, int value) {
        this.moveCondition = moveCondition;
        this.value = value;
    }

    @Override
    public boolean movable() {
        return value >= moveCondition;
    }
}
