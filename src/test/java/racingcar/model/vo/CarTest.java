package racingcar.model.vo;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarTest {

    public static Stream<Arguments> provideCarArguments() {
        return Stream.of(
            Arguments.of(new Car("a"), false)
        );
    }

    @DisplayName("가장_멀리_전진한_자동차_테스트")
    @ParameterizedTest
    @MethodSource("provideCarArguments")
    void carTest(Car car, boolean expected) {
        assertThat(car.isMax(5, car)).isEqualTo(expected);
    }
}
