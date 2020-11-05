package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("Car 생성 시 distance 를 0으로 초기화 여부")
    @Test
    void createCar() {
        Car car = new Car();
        assertThat(car.getPosition()).isZero();
        assertThat(car).isNotNull();
    }

    @DisplayName("Car 이동 또는 정지 여부")
    @ParameterizedTest
    @MethodSource("moveCase")
    void moveOrStopCar(boolean moveOrNot, int distance) {
        Car car = new Car();
        car.move(() -> moveOrNot);
        int result = car.getPosition();
        assertThat(result).isEqualTo(distance);
    }

    private static Stream<Arguments> moveCase() {
        return Stream.of(
                Arguments.of(true, 1),
                Arguments.of(false, 0)
        );
    }
}
