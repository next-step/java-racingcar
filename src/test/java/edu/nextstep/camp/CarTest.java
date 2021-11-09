package edu.nextstep.camp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static edu.nextstep.camp.TestMovePolicy.ALWAYS_MOVE_POLICY;
import static edu.nextstep.camp.TestMovePolicy.NEVER_MOVE_POLICY;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    final String testName = "test0";

    @Test
    public void create() {
        Car car = new Car(testName, RandomMovePolicy.getInstance());
        assertThat(car.name()).isEqualTo(testName);
        assertThat(car.position()).isEqualTo(Position.ofZero());
    }

    @ParameterizedTest(name = "creation failed due to invalid name: {arguments}")
    @NullAndEmptySource
    @ValueSource(strings = {"123456", "too-long"})
    public void createFailByName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(name, ALWAYS_MOVE_POLICY));
    }

    @ParameterizedTest(name = "creation failed due to invalid move policy: {arguments}")
    @NullSource
    public void createFailByMovePolicy(MovePolicy movePolicy) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(testName, movePolicy));
    }

    @Test
    public void move() {
        Car car = new Car(testName, ALWAYS_MOVE_POLICY);
        assertThat(car.position().toInt()).isEqualTo(0);
        car.attemptToMove();
        assertThat(car.position().toInt()).isEqualTo(1);
    }

    @Test
    public void notMoveByPolicy() {
        Car car = new Car(testName, NEVER_MOVE_POLICY);
        assertThat(car.position().toInt()).isEqualTo(0);
        car.attemptToMove();
        assertThat(car.position().toInt()).isEqualTo(0);
    }
}
