package com.nextstep.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    private final List<CarName> carNames = Arrays.asList(new CarName("test1"), new CarName("test2"), new CarName("test3"));

    @DisplayName("우승 한 car의 이름들을 가져오는지 확인")
    @ParameterizedTest
    @MethodSource
    public void getWinnerNames(Supplier<Integer> numberGenerator, int moveCount, String expected) {
        Race race = new Race(carNames, numberGenerator);

        for (int ix = 0 ; ix < moveCount ; ix ++) {
            race.moveAndGet();
        }
        assertThat(race.getWinnerNames()).isEqualTo(expected);
    }

    private static Stream<Arguments> getWinnerNames() {
        return Stream.of(
                Arguments.of(new SpecificGenerator(5, 1, 1), 5, "test1"),
                Arguments.of(new SpecificGenerator(1, 5, 1), 5, "test2"),
                Arguments.of(new SpecificGenerator(1, 1, 5), 5, "test3"),
                Arguments.of(new SpecificGenerator(1, 5, 5), 5, "test2,test3"),
                Arguments.of(new SpecificGenerator(5, 5, 5), 5, "test1,test2,test3")
        );
    }

    private static class SpecificGenerator implements  Supplier<Integer> {
        private int[] values;
        private int idx = 0;

        public SpecificGenerator(int ... values) {
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
