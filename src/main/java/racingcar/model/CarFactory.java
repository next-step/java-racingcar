package racingcar.model;

public final class CarFactory {

    private static final RandomValueGenerator DEFAULT_RANDOM_VALUE_GENERATOR
        = RandomWrapper.INSTANCE;
    private static final MovePolicy DEFAULT_CAR_MOVE_POLICY
        = new OneStepMovePolicy();
    private static final MoveCondition DEFAULT_CAR_MOVE_CONDITION
        = new SixtyPercentRandomMoveCondition(DEFAULT_RANDOM_VALUE_GENERATOR);

    private CarFactory() {
    }

    public static MovePolicy getDefaultCarMovePolicy() {
        return DEFAULT_CAR_MOVE_POLICY;
    }

    public static MoveCondition getDefaultCarMoveCondition() {
        return DEFAULT_CAR_MOVE_CONDITION;
    }

    public static Car getCar(
        final CarName carName,
        final MovePolicy movePolicy,
        final MoveCondition moveCondition
    ) {
        return new Car(carName, movePolicy, moveCondition);
    }

    public static Car getDefaultCar(final CarName carName) {
        return getCar(carName, DEFAULT_CAR_MOVE_POLICY, DEFAULT_CAR_MOVE_CONDITION);
    }

}
