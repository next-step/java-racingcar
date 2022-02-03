package racingcar.model.vo;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.model.domain.Car;

public class CarTest {

    public static Stream<Arguments> provideCarArguments() {
        return Stream.of(
            Arguments.of(new Car("a"), 5, false),
            Arguments.of(new Car("a"), 1, true)
        );
    }

    @DisplayName("가장_멀리_전진한_자동차_테스트")
    @ParameterizedTest
    @MethodSource("provideCarArguments")
    void carTest(Car car, int number, boolean expected) {
        car.moveForward();
        assertThat(car.isMax(number, car)).isEqualTo(expected);
    }
}
