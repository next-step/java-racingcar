package edu.nextstep.camp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static edu.nextstep.camp.TestMovePolicy.ALWAYS_MOVE_POLICY;
import static edu.nextstep.camp.TestMovePolicy.NEVER_MOVE_POLICY;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private static final Position INITIAL_POSITION = Position.ofZero();
    private static final Position FORWARDED_POSITION = Position.of(1);

    private static final Name TEST_NAME = Name.of("test0");

    @Test
    public void create() {
        Car car = Car.of(TEST_NAME, RandomMovePolicy.getInstance());
        assertThat(car.name()).isEqualTo(TEST_NAME);
        assertThat(car.position()).isEqualTo(Position.ofZero());
    }

    @ParameterizedTest(name = "creation failed by invalid input: {arguments}")
    @NullSource
    public void createFailByName(MovePolicy movePolicy) {
        assertThatIllegalArgumentException().isThrownBy(() -> Car.of(TEST_NAME, movePolicy));
    }

    @Test
    public void isPositionOf() {
        Car car = Car.of(TEST_NAME, ALWAYS_MOVE_POLICY);
        assertThat(car.isPositionOf(INITIAL_POSITION)).isTrue();
        assertThat(car.isPositionOf(FORWARDED_POSITION)).isFalse();
    }

    @Test
    public void move() {
        Car car = Car.of(TEST_NAME, ALWAYS_MOVE_POLICY);
        assertThat(car.isPositionOf(INITIAL_POSITION)).isTrue();
        car.attemptToMove();
        assertThat(car.isPositionOf(INITIAL_POSITION)).isFalse();
        assertThat(car.isPositionOf(FORWARDED_POSITION)).isTrue();
    }

    @Test
    public void notMoveByPolicy() {
        Car car = Car.of(TEST_NAME, NEVER_MOVE_POLICY);
        assertThat(car.isPositionOf(INITIAL_POSITION)).isTrue();
        car.attemptToMove();
        assertThat(car.isPositionOf(INITIAL_POSITION)).isTrue();
        assertThat(car.isPositionOf(FORWARDED_POSITION)).isFalse();
    }
}
