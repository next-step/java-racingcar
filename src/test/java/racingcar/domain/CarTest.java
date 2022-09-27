package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.Moving.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {
    @DisplayName("이동신호가 GO 이면 이동시 주행거리가 1만큼 증가하고 이동신호가 GO 가 아니면 이동하여도 주행거리가 증가하지 않는다.")
    @ParameterizedTest
    @MethodSource("moving")
    void move(Car car, Moving moving, Distance expected) {
        assertThat(car.move(moving)).isEqualTo(expected);
    }
    
    private static Stream<Arguments> moving() {
        return Stream.of(
                Arguments.arguments(car(0), STOP, new Distance(0)),
                Arguments.arguments(car(0), GO, new Distance(1)),
                Arguments.arguments(car(3), GO, new Distance(4))
        );
    }
    
    private static Car car(int distance) {
        Car car = new Car();
        for(int tryCount = 0; tryCount < distance; tryCount++) {
            car.move(GO);
        }
        return car;
    }
}
