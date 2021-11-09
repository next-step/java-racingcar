package edu.nextstep.camp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static edu.nextstep.camp.TestMovePolicy.ALWAYS_MOVE_POLICY;
import static edu.nextstep.camp.TestMovePolicy.NEVER_MOVE_POLICY;
import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private static final String[] TEST_NAME_LIST = {"test0", "test1", "test2", "test3"};
    private static final String TEST_NAME = "test0";

    @Test
    public void create() {
        Car car = Car.of(TEST_NAME, RandomMovePolicy.getInstance());
        assertThat(car.name()).isEqualTo(TEST_NAME);
        assertThat(car.position()).isEqualTo(Position.ofZero());
    }

    static Stream<Arguments> parseIllegalArgumentsOfCar() {
        return Stream.of(
                Arguments.of(null, ALWAYS_MOVE_POLICY),
                Arguments.of("", ALWAYS_MOVE_POLICY),
                Arguments.of("test11", ALWAYS_MOVE_POLICY),
                Arguments.of("too-long", ALWAYS_MOVE_POLICY),
                Arguments.of(TEST_NAME, null)
        );
    }

    @ParameterizedTest(name = "creation failed by invalid input: {arguments}")
    @MethodSource("parseIllegalArgumentsOfCar")
    public void createFailByName(String name, MovePolicy movePolicy) {
        assertThatIllegalArgumentException().isThrownBy(() -> Car.of(name, movePolicy));
    }

    @Test
    public void creatAsList() {
        List<Car> cars = Car.of(TEST_NAME_LIST, ALWAYS_MOVE_POLICY);
        assertThat(cars).hasSameSizeAs(TEST_NAME_LIST);
        assertThat(cars.stream().map(Car::name)).hasSameElementsAs(Arrays.asList(TEST_NAME_LIST));
    }


    static Stream<Arguments> parseIllegalArgumentsOfCarList() {
        return Stream.of(
                Arguments.of(TEST_NAME_LIST, null),
                Arguments.of(null, ALWAYS_MOVE_POLICY),
                Arguments.of(new String[] {}, ALWAYS_MOVE_POLICY),
                Arguments.of(new String[] {"test0", "test11"}, ALWAYS_MOVE_POLICY)
        );
    }


    @ParameterizedTest(name = "creation failed by invalid input: {arguments}")
    @MethodSource("parseIllegalArgumentsOfCarList")
    public void createFailByName(String[] names, MovePolicy movePolicy) {
        assertThatIllegalArgumentException().isThrownBy(() -> Car.of(names, movePolicy));
    }


    @Test
    public void move() {
        Car car = Car.of(TEST_NAME, ALWAYS_MOVE_POLICY);
        assertThat(car.position().toInt()).isEqualTo(0);
        car.attemptToMove();
        assertThat(car.position().toInt()).isEqualTo(1);
    }

    @Test
    public void notMoveByPolicy() {
        Car car = Car.of(TEST_NAME, NEVER_MOVE_POLICY);
        assertThat(car.position().toInt()).isEqualTo(0);
        car.attemptToMove();
        assertThat(car.position().toInt()).isEqualTo(0);
    }
}
