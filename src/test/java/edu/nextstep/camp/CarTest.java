package edu.nextstep.camp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static edu.nextstep.camp.TestMovePolicy.ALWAYS_MOVE_POLICY;
import static edu.nextstep.camp.TestMovePolicy.NEVER_MOVE_POLICY;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    public void create() {
        Car car = new Car();
        assertThat(car.position()).isEqualTo(Position.ofZero());
    }

    @ParameterizedTest
    @NullSource
    public void createFail(MovePolicy movePolicy) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(movePolicy));
    }

    @Test
    public void move() {
        Car car = new Car(ALWAYS_MOVE_POLICY);
        assertThat(car.position().toInt()).isEqualTo(0);
        car.attemptToMove();
        assertThat(car.position().toInt()).isEqualTo(1);
    }

    @Test
    public void notMoveByPolicy() {
        Car car = new Car(NEVER_MOVE_POLICY);
        assertThat(car.position().toInt()).isEqualTo(0);
        car.attemptToMove();
        assertThat(car.position().toInt()).isEqualTo(0);
    }
}
