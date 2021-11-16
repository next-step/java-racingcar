package car_racing;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("when create car, default status are set - position equals to 0")
    void createCar() {
        // given
        // when
        Car car = new Car();

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Move car with test strategy - position becomes plus 1")
    void moveCar() {
        // given
        Car car = new Car();
        MoveStrategy moveStrategy = new AbleToTestMoveStrategy();

        // when
        car.move(moveStrategy);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("No move car with test strategy - position becomes the same as before")
    void stopCar() {
        // given
        Car car = new Car();
        MoveStrategy moveStrategy = new NotAbleToMoveStrategy();

        // when
        car.move(moveStrategy);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
    @ParameterizedTest
    @DisplayName("when use RandomMoveStrategy to move car, position can be plus one or same as before")
    @MethodSource("randomMoveResult")
    void randomlyMoveCar(int defaultPosition, List<Integer> afterMovePosition) {
        // given
        Car car = new Car(defaultPosition);
        MoveStrategy moveStrategy = new RandomMoveStrategy();

        // when
        car.move(moveStrategy);

        // then
        assertThat(car.getPosition()).isIn(afterMovePosition);
    }

    static Stream<Arguments> randomMoveResult() {
        return Stream.of(
                Arguments.of(0, Arrays.asList(0, 1)),
                Arguments.of(1, Arrays.asList(1, 2)),
                Arguments.of(2, Arrays.asList(2, 3)),
                Arguments.of(3, Arrays.asList(3, 4)),
                Arguments.of(4, Arrays.asList(4, 5))
        );
    }
}
