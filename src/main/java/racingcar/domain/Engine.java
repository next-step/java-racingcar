package racingcar.domain;

public abstract class Engine {

    private static final int DEFAULT_MOVE_CONDITION = 4;
    private final int moveDistance;
    private MovementRule rule;

    abstract int fuelInject();

    public Engine() {
        rule = (fuel) -> fuel > DEFAULT_MOVE_CONDITION;
        moveDistance = 1;
    }

    public Engine(int moveDistance) {
        super();
        this.moveDistance = moveDistance;
    }

    public Engine(MovementRule rule, int moveDistance) {
        this.rule = rule;
        this.moveDistance = moveDistance;
    }

    public final int move() {

        if (rule.isEnoughFuel(fuelInject())) {
            return moveDistance;
        }
        return 0;
    }
}
