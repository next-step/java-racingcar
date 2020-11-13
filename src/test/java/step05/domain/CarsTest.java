package step05.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private static Stream<Arguments> provideCarNamesResult() {
        return Stream.of(
                Arguments.of(
                        new String[]{"eun", "young"},
                        new ArrayList<Car>() {
                            Car.of("eun"),
                                    Car.of("young")
                        })
        );
    }

    @DisplayName("자동차 이름들을 받아 자동차들 생성")
    @ParameterizedTest
    @MethodSource("provideCarNamesResult")
    public void test_constructor_Cars(String[] carNames, List<Car> expect) {
        Cars cars = Cars.of(carNames);
        assertThat(cars).isEqualTo(Cars.of(expect));
    }

    private static Stream<Arguments> provideMovableResult() {
        return Stream.of(
                Arguments.of()
        );
    }

    @DisplayName("자동차를 한회차 이동시킴")
    @Test
    public void test_move() {
        Cars cars = Cars.of(
                new ArrayList<Car>() {
                    Car.of("eun",1),
                            Car.of("young",2)
                });
        assertThat(cars.move(() -> true)).isEqualTo(Cars.of(
                new ArrayList<Car>() {
                    Car.of("eun",2),
                            Car.of("young",3)
                }));
    }

}
