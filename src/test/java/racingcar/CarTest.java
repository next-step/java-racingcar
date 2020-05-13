package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("Car 생성 시 distance 를 0으로 초기화")
    @Test
    void create() {
        assertThat(Car.newInstance().getPosition()).isEqualTo(Car.DEFAULT_DISTANCE);
    }

    @DisplayName("Car 는 이동 또는 정지")
    @ParameterizedTest
    @MethodSource("moveCase")
    void move(final boolean moveOrNot, final int distance) {
        Car car = Car.newInstance();
        car.move(() -> moveOrNot);
        assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_DISTANCE + distance);
    }

    private static Stream<Arguments> moveCase() {
        return Stream.of(
                Arguments.of(true, 1),
                Arguments.of(false, 0)
        );
    }
}
