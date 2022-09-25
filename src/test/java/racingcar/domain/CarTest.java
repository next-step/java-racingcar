package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarTest {
    @ParameterizedTest
    @MethodSource("moving")
    void move(Car car, MovingFlag flag, Distance expected) {
        assertThat(car.move(flag)).isEqualTo(expected);
    }
    
    private static Stream<Arguments> moving() {
        return Stream.of(
                Arguments.arguments(car(0), flag(false), new Distance(0)),
                Arguments.arguments(car(0), flag(true), new Distance(1)),
                Arguments.arguments(car(3), flag(true), new Distance(4))
        );
    }
    
    private static Car car(int distance) {
        Car car = new Car();
        for(int tryCount = 0; tryCount < distance; tryCount++) {
            car.move(flag(true));
        }
        return car;
    }
    
    private static MovingFlag flag(boolean flag) {
        if (flag) {
            return new MovingFlag(4);
        }
        return new MovingFlag(3);
    }
}
