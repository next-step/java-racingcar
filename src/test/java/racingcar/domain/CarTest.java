package racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.strategy.MovingStrategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest(name = "{2}")
    @MethodSource("strategyParameterProvider")
    void move(MovingStrategy movingStrategy, Position expected, String displayMessage) {
        Car car = new Car("carA");
        car.move(movingStrategy);

        assertThat(car.getPlayResult().getPosition()).isEqualTo(expected);
    }

    static Stream<Arguments> strategyParameterProvider() {
        return Stream.of(
                Arguments.of((MovingStrategy) () -> true, new Position(1), "move() 전진 가능한 경우"),
                Arguments.of((MovingStrategy) () -> false, new Position(0), "move() 전진 불가능한 경우")
        );
    }
}
