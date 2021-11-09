package edu.nextstep.camp;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static edu.nextstep.camp.TestMovePolicy.ALWAYS_MOVE_POLICY;
import static edu.nextstep.camp.TestMovePolicy.NEVER_MOVE_POLICY;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private static final String TEST_NAME = "test0";

    @Test
    public void create() {
        Car car = new Car(TEST_NAME, RandomMovePolicy.getInstance());
        assertThat(car.name()).isEqualTo(TEST_NAME);
        assertThat(car.position()).isEqualTo(Position.ofZero());
    }

    static Stream<Arguments> parseIllegalArguments() {
        return Stream.of(
                Arguments.of(null, ALWAYS_MOVE_POLICY),
                Arguments.of("", ALWAYS_MOVE_POLICY),
                Arguments.of("test11", ALWAYS_MOVE_POLICY),
                Arguments.of("too-long", ALWAYS_MOVE_POLICY),
                Arguments.of(TEST_NAME, null)
        );
    }

    @ParameterizedTest(name = "creation failed by invalid input: {arguments}")
    @MethodSource("parseIllegalArguments")
    public void createFailByName(String name, MovePolicy movePolicy) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car(name, movePolicy));
    }

    @Test
    public void move() {
        Car car = new Car(TEST_NAME, ALWAYS_MOVE_POLICY);
        assertThat(car.position().toInt()).isEqualTo(0);
        car.attemptToMove();
        assertThat(car.position().toInt()).isEqualTo(1);
    }

    @Test
    public void notMoveByPolicy() {
        Car car = new Car(TEST_NAME, NEVER_MOVE_POLICY);
        assertThat(car.position().toInt()).isEqualTo(0);
        car.attemptToMove();
        assertThat(car.position().toInt()).isEqualTo(0);
    }
}
