package com.nextstep.racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTests {
    @DisplayName("String 리스트을 입력받아서 Car 콜렉션을 만들 수 있다.")
    @ParameterizedTest
    @MethodSource("stringList")
    void createCarsByStringCollectionTest(List<String> stringCollection, int size) {
        CarFactory carFactory = new CarFactory();
        List<Car> cars = carFactory.createByStringList(stringCollection);
        assertThat(cars.size()).isEqualTo(size);
    }
    public static Stream<Arguments> stringList()  {
        return Stream.of(
                Arguments.of(Arrays.asList("poppo"), 1),
                Arguments.of(Arrays.asList("poppo", "ita"), 2),
                Arguments.of(Arrays.asList("poppo", "ita", "saul"), 3)
        );
    }
}
