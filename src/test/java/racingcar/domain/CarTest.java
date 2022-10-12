package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.moving.Moving.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.moving.Moving;

class CarTest {
    @DisplayName("이동신호가 GO 이면 이동시 주행거리가 1만큼 증가하고 이동신호가 GO 가 아니면 이동하여도 주행거리가 증가하지 않는다.")
    @ParameterizedTest
    @MethodSource("moving")
    void move(Car car, Moving moving, Distance expected) {
        assertThat(car.move(moving)).isEqualTo(expected);
    }

    @DisplayName("car1 의 주행거리가 더 길다면 1을 리턴하고 같다면 0을 리턴하고 작다면 -1을 리턴한다.")
    @ParameterizedTest
    @MethodSource("compareToSet")
    void compareTo(Car car1, Car car2, int expected) {
        assertThat(car1.compareTo(car2)).isEqualTo(expected);
    }

    @DisplayName("이동거리가 같은 차라면 true 를 리턴하고 아니라면 false 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("sameDistanceSet")
    void sameDistance(Car car1, Car car2, boolean expected) {
        assertThat(car1.sameDistance(car2)).isEqualTo(expected);
    }

    private static Stream<Arguments> moving() {
        return Stream.of(
                Arguments.arguments(car(0), STOP, ZERO),
                Arguments.arguments(car(0), GO, distance(1)),
                Arguments.arguments(car(3), GO, distance(4))
        );
    }

    private static Stream<Arguments> compareToSet() {
        return Stream.of(
                Arguments.arguments(car("pobby", 2), car("pobby", 1), 1),
                Arguments.arguments(car("pobby", 2), car("luna", 2), 0),
                Arguments.arguments(car("pobby", 2), car("rein", 3), -1)
        );
    }

    private static Stream<Arguments> sameDistanceSet() {
        return Stream.of(
                Arguments.arguments(car("pobby", 2), car("pobby", 1), false),
                Arguments.arguments(car("pobby", 2), car("luna", 2), true),
                Arguments.arguments(car("pobby", 3), car("rein", 2), false)
        );
    }
    
    private static Car car(String name, int distance) {
        Car car = new Car(name);
        for (int count = 0; count < distance; count++) {
            car.move(GO);
        }
        return car;
    }
    
    private static Car car(int distance) {
        Car car = new Car("name");
        for(int tryCount = 0; tryCount < distance; tryCount++) {
            car.move(GO);
        }
        return car;
    }

    private static Distance distance(int distance) {
        return new Distance(distance);
    }

    private static final Distance ZERO = distance(0);
}
