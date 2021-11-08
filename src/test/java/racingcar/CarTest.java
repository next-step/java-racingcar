package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_전진() {
        Car car = new Car();
        car.moveOrNot(8);
        assertThat(car).isEqualTo(new Car(new Status(1)));
    }

    @Test
    void 자동차_멈춤() {
        Car car = new Car();
        car.moveOrNot(2);
        assertThat(car).isEqualTo(new Car());
    }

    @ParameterizedTest
    @MethodSource("자동차_전진횟수리턴_데이터")
    void 자동차_전진횟수리턴(Integer[] input, int result) {
        Car car = new Car();
        for (Integer randomValue : input) {
            car.moveOrNot(randomValue);
        }
        assertThat(car.forwardCount()).isEqualTo(result);
    }

    static Stream<Arguments> 자동차_전진횟수리턴_데이터() {
        return Stream.of(
                Arguments.of(new Integer[]{7, 6, 5}, 3),
                Arguments.of(new Integer[]{2, 6, 5}, 2),
                Arguments.of(new Integer[]{7, 3, 1}, 1),
                Arguments.of(new Integer[]{2, 2, 1}, 0)
        );
    }
}