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
    private static final Random random = new Random();

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

    private static Stream<Arguments> moveAndGet() {
        Supplier<Integer> lessThanGenerator = () -> random.nextInt(4);
        Supplier<Integer> greaterThanGenerator = () -> random.nextInt(6) + 4;
        return Stream.of(
                Arguments.of(lessThanGenerator, 5, 0),
                Arguments.of(greaterThanGenerator, 5, 5)
        );
    }

    @DisplayName("Car list 중 하나라도 끝나면 true인지 확인")
    @ParameterizedTest
    @MethodSource
    public void isFinished(Supplier<Integer> numberGenerator, int moveLimit, boolean expected) {
        final int carCount = 3;
        Race race = new Race(carCount, moveLimit);

        for ( int ix = 0 ; ix < moveLimit ; ix ++ ) {
            race.moveAndGet(numberGenerator);
        }

        assertThat(race.isFinished()).isEqualTo(expected);
    }

    private static Stream<Arguments> isFinished() {
        return Stream.of(
                Arguments.of(new SpecificGenerator(5, 1, 1), 5, true),
                Arguments.of(new SpecificGenerator(1, 5, 1), 5, true),
                Arguments.of(new SpecificGenerator(1, 1, 5), 5, true),
                Arguments.of(new SpecificGenerator(1, 1, 1), 5, false)
        );
    }

    private static class SpecificGenerator implements  Supplier<Integer> {
        private int[] values;
        private int idx = 0;
        public SpecificGenerator(int ... values){
            this.values = values;
        }
        @Override
        public Integer get() {
            if (idx >= values.length) {
                idx = 0;
            }
            return values[idx++];
        }
    }
}
