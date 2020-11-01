package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("DEFAULT Position CAR 생성 테스트")
    @Test
    void DEFAULT_Position_CAR_생성_테스트() {
        Car car = Car.of();
        final int result = car.position();
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("Position CAR 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 13})
    void Position_CAR_생성_테스트(int input) {
        Car car = Car.of(input);
        final int result = car.position();
        assertThat(result).isEqualTo(input);
    }

    private static Stream<Arguments> provideMovingCarResult() {
        return Stream.of(
                Arguments.of(true, 2),
                Arguments.of(false, 1)
        );
    }

    @DisplayName("CAR move 테스트")
    @ParameterizedTest
    @MethodSource("provideMovingCarResult")
    void CAR_이동_테스트(boolean input, int expected) {
        final Car car = Car.of();
        car.move(() -> input);
        final int result = car.position();
        assertThat(result).isEqualTo(expected);
    }

}
