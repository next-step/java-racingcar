package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.moving.Moving;

class CarsTest {
    @DisplayName("가장 긴 거리를 이동한 자동차들을 리턴한다.")
    @ParameterizedTest
    @MethodSource("longestSet")
    void longest(Cars cars, Cars expected) {
        assertThat(cars.longest()).isEqualTo(expected);
    }

    @DisplayName("자동차 이름들을 가지고 자동차들을 생성한다.")
    @ParameterizedTest
    @MethodSource("fromSet")
    void from(CarNames names, Cars cars) {
        assertThat(Cars.from(names)).isEqualTo(cars);
    }

    @DisplayName("자동차들의 이름을 리턴한다.")
    @ParameterizedTest
    @MethodSource("namesSet")
    void names(CarNames names, List<String> expected) {
        assertThat(Cars.from(names).names()).hasSameElementsAs(expected);
    }
    
    private static Stream<Arguments> namesSet() {
        return Stream.of(
            Arguments.arguments(CarNames.of("pobby, luna"), List.of("pobby", "luna")),
            Arguments.arguments(CarNames.of("pobby, luna, rein"), List.of("pobby", "luna", "rein"))
        );
    }

    private static Stream<Arguments> fromSet() {
        return Stream.of(
            Arguments.arguments(CarNames.of("pobby, luna"), cars(List.of("pobby", "luna"))),
            Arguments.arguments(CarNames.of("pobby"), cars(List.of("pobby"))),
            Arguments.arguments(CarNames.of("pobby, luna, rein"), cars(List.of("pobby", "luna", "rein")))
        );
    }
    
    private static Cars cars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    private static Cars cars(Car... cars) {
        return new Cars(Arrays.asList(cars));
    }
    
    private static Car car(String name, int distance) {
        Car car = new Car(name);
        for (int count = 0; count < distance; count++) {
            car.move(Moving.GO);
        }
        return car;
    }
    
    private static Stream<Arguments> longestSet() {
        return Stream.of(
            Arguments.arguments(cars(car("pobby", 3), car("luna", 2)), 
                                cars(car("pobby", 3))),
            Arguments.arguments(cars(car("pobby", 3), car("luna", 3)), 
                                cars(car("pobby", 3), car("luna", 3))),
            Arguments.arguments(cars(car("pobby", 3), car("luna", 3), car("rein", 2)),
                                cars(car("pobby", 3), car("luna", 3)))
        );
    }
}
