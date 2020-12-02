package com.nextstep.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @DisplayName("0-3만 나오는 경우와 4-9만 나오는 경우 position의 변화 체크")
    @ParameterizedTest
    @MethodSource
    public void moveAndGet(Supplier<Integer> numberGenerator, int moveLimit, int expected) {
        final int carCount = 3;
        Race race = new Race(carCount, moveLimit);

        List<Car> carList = null;

        for ( int ix = 0 ; ix < moveLimit ; ix ++ ) {
            carList = race.moveAndGet(numberGenerator);
        }
        assertThat(carList).isNotNull();

        for ( Car car : carList ) {
            assertThat(car.getPosition()).isEqualTo(expected);
        }
    }

    static private Stream<Arguments> moveAndGet() {
        Supplier<Integer> lessThanGenerator = () -> new Random().nextInt(4);
        Supplier<Integer> greaterThanGenerator = () -> new Random().nextInt(6) + 4;
        return Stream.of(
                Arguments.of(lessThanGenerator, 5, 0),
                Arguments.of(greaterThanGenerator, 5, 5)
        );
    }
}
