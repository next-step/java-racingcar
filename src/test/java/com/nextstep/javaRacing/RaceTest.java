package com.nextstep.javaRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    private static final MoveStrategy mockMoveStrategy = () -> 1;

    @ParameterizedTest
    @CsvSource(value = {"1,2", "3,4", "5,6"})
    @DisplayName("레이스 후 자동차들의 위치가 변경된다")
    void race(int cars, int turns) {
        List<Car> carList = new LinkedList<>();
        for (int i = 0; i < cars; i++) {
            carList.add(new RaceCar("raceCar"+i, mockMoveStrategy));
        }
        Race race = new Race(carList, turns);

        race.race();
        int endPositionSum = race.cars.stream().mapToInt(c->c.position()).sum();
        int expected = cars * turns;
        assertThat(endPositionSum).isEqualTo(expected);
    }
}