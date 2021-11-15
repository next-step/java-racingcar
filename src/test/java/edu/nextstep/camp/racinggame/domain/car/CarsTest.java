package edu.nextstep.camp.racinggame.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.nextstep.camp.racinggame.domain.car.policy.MovePolicy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static edu.nextstep.camp.racinggame.TestMovePolicy.ALWAYS_MOVE_POLICY;
import static edu.nextstep.camp.racinggame.TestMovePolicy.NEVER_MOVE_POLICY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarsTest {
    private static final List<Name> TEST_NAME_LIST = Stream.of("test0", "test1", "test2", "test3")
            .map(Name::of)
            .collect(Collectors.toList());

    static List<Car> getTestCars() {
        final Car TEST_CAR_0 = Car.of(TEST_NAME_LIST.get(0), ALWAYS_MOVE_POLICY);
        final Car TEST_CAR_1 = Car.of(TEST_NAME_LIST.get(1), NEVER_MOVE_POLICY);
        final Car TEST_CAR_2 = Car.of(TEST_NAME_LIST.get(2), ALWAYS_MOVE_POLICY);
        final Car TEST_CAR_3 = Car.of(TEST_NAME_LIST.get(3), NEVER_MOVE_POLICY);

        return List.of(TEST_CAR_0, TEST_CAR_1, TEST_CAR_2, TEST_CAR_3);
    }

    @Test
    public void createFromNames() {
        Cars cars = Cars.of(TEST_NAME_LIST, ALWAYS_MOVE_POLICY);
        assertThat(cars.collect()).hasSameSizeAs(TEST_NAME_LIST);
    }

    @Test
    public void createFromList() {
        List<Car> carList = getTestCars();
        Cars cars = Cars.of(carList);
        assertThat(cars.collect()).hasSameElementsAs(carList);
    }

    @Test
    public void createFromCar() {
        final Car TEST_CAR_0 = Car.of(TEST_NAME_LIST.get(0), ALWAYS_MOVE_POLICY);
        final Car TEST_CAR_1 = Car.of(TEST_NAME_LIST.get(1), NEVER_MOVE_POLICY);
        Cars cars = Cars.of(TEST_CAR_0, TEST_CAR_1);
        assertThat(cars.collect()).hasSameElementsAs(List.of(TEST_CAR_0, TEST_CAR_1));
    }

    static Stream<Arguments> parseIllegalArgumentsOfCarList() {
        return Stream.of(
                Arguments.of(TEST_NAME_LIST, null),
                Arguments.of(null, ALWAYS_MOVE_POLICY),
                Arguments.of(Collections.emptyList(), ALWAYS_MOVE_POLICY)
        );
    }

    @ParameterizedTest(name = "creation failed by invalid input: {arguments}")
    @MethodSource("parseIllegalArgumentsOfCarList")
    public void createFailByName(List<Name> names, MovePolicy movePolicy) {
        assertThatIllegalArgumentException().isThrownBy(() -> Cars.of(names, movePolicy));
    }

    @Test
    public void size() {
        List<Car> carList = getTestCars();
        Cars cars = Cars.of(carList);
        assertThat(cars.size()).isEqualTo(carList.size());
    }

    @Test
    public void stream() {
        Cars cars = Cars.of(TEST_NAME_LIST, ALWAYS_MOVE_POLICY);
        assertThat(cars.stream().map(Car::name)).hasSameElementsAs(TEST_NAME_LIST);
    }
}
