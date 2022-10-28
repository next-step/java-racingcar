package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    // TODO
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    private static final CarName DEFAULT_CAR_NAME = CarName.from("beth");
    private static final MovePolicy GIANT_STEP_MOVE_POLICY = () -> Distance.from(75);
    private static final MoveCondition ALWAYS_MOVE_CONDITION = () -> true;

    @Test
    void nullName() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> CarFactory.getDefaultCar(null))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void nullMovePolicy() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> CarFactory.getCar(DEFAULT_CAR_NAME, null,
                CarFactory.getDefaultCarMoveCondition()))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void nullMoveCondition() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(
                () -> CarFactory.getCar(DEFAULT_CAR_NAME, CarFactory.getDefaultCarMovePolicy(),
                    null))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void move_defaultPolicy_defaultCondition() {
        final Car car = CarFactory.getDefaultCar(DEFAULT_CAR_NAME);
        assertThat(car.getDistance()).isEqualTo(Distance.ZERO);
        car.move();
        assertThat(car.getDistance()).isIn(Distance.ZERO, Distance.ONE);
    }

    @Test
    void move_defaultPolicy_customCondition() {
        final Car car = CarFactory.getCar(DEFAULT_CAR_NAME, CarFactory.getDefaultCarMovePolicy(),
            ALWAYS_MOVE_CONDITION);
        assertThat(car.getDistance()).isEqualTo(Distance.ZERO);
        car.move();
        assertThat(car.getDistance()).isEqualTo(CarFactory.getDefaultCarMovePolicy().getSteps());
    }

    @Test
    void move_customPolicy_defaultCondition() {
        final Car car = CarFactory.getCar(DEFAULT_CAR_NAME, GIANT_STEP_MOVE_POLICY,
            CarFactory.getDefaultCarMoveCondition());
        assertThat(car.getDistance()).isEqualTo(Distance.ZERO);
        car.move();
        assertThat(car.getDistance()).isIn(Distance.ZERO, GIANT_STEP_MOVE_POLICY.getSteps());
    }

    @Test
    void move_customPolicy_customCondition() {
        final Car car = CarFactory.getCar(DEFAULT_CAR_NAME, GIANT_STEP_MOVE_POLICY,
            ALWAYS_MOVE_CONDITION);
        assertThat(car.getDistance()).isEqualTo(Distance.ZERO);
        car.move();
        assertThat(car.getDistance()).isEqualTo(GIANT_STEP_MOVE_POLICY.getSteps());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void move_movingForwardBasedOnPolicyAndCondition(final int count) {
        final Car car = CarFactory.getCar(DEFAULT_CAR_NAME, GIANT_STEP_MOVE_POLICY,
            ALWAYS_MOVE_CONDITION);

        for (int i = 0; i < count; i++) {
            Distance prevDistance = car.getDistance();

            car.move();

            assertThat(car.getDistance())
                .isEqualTo(prevDistance.plus(GIANT_STEP_MOVE_POLICY.getSteps()));

            prevDistance = car.getDistance();

        }
    }

}
