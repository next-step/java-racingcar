package racingcar.domain;

public class Engine {

    private static final int DEFAULT_MOVE_CONDITION = 4;
    private static final int MOVE = 1;
    private static final int STOP = 0;

    private final MovementRule rule;
    private final Fuel fuel;

    public Engine() {
        rule = (condition) -> condition > DEFAULT_MOVE_CONDITION;
        fuel = RandomFuel::nextInt;
    }

    public Engine(Fuel fuel) {
        this((condition) -> condition > DEFAULT_MOVE_CONDITION, fuel);
    }

    public Engine(MovementRule rule, Fuel fuel) {
        this.rule = rule;
        this.fuel = fuel;
    }

    public final int move() {

        if (rule.isEnoughFuel(fuel.getAsInt())) {
            return MOVE;
        }

        return STOP;
    }
}
