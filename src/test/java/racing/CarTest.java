package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Car;
import racing.utils.Counter;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("전략에 따라 자동차 전진 또는 멈춤")
    @ParameterizedTest
    @MethodSource("provideSource")
    void carMoveForward(Boolean isMovable, Counter expected) {
        Car carA = new Car("carA");
        carA.run(() -> isMovable);
        assertThat(carA.getCounter()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideSource() {
        return Stream.of(
                Arguments.of(true, new Counter(1)),
                Arguments.of(false, new Counter(0))
        );
    }
}