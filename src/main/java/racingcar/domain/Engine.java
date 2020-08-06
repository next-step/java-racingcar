package racingcar.domain;

public class Engine {

    private static final int DEFAULT_MOVE_CONDITION = 4;
    private static final int MOVE = 1;
    private static final int STOP = 0;

    private final MovementRule rule;
    private final Fuel fuel;

    public Engine() {
        this(() -> RandomPower.getInstance().nextInt());
    }

    public Engine(Fuel fuel) {
        this((power) -> power >= DEFAULT_MOVE_CONDITION, fuel);
    }

    public Engine(MovementRule rule, Fuel fuel) {
        this.rule = rule;
        this.fuel = fuel;
    }

    public final int move() {

        if (rule.isEnoughPower(fuel.getAsInt())) {
            return MOVE;
        }

        return STOP;
    }
}
