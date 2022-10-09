package com.nextlevel.kky.racing;

import com.nextlevel.kky.racing.core.Car;
import com.nextlevel.kky.racing.core.CarRacingExecutor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingExecutorTest {

    static int[] index = {0, 0, 0, 0};

    @Test
    void getWinnersTest() {
        CarRacingExecutor carRacingExecutor = new CarRacingExecutor(
                Arrays.asList(
                        new Car("kky", () -> new int[]{4, 5, 6}[index[0]++]),
                        new Car("kdy", () -> new int[]{1, 2, 3}[index[1]++]),
                        new Car("poltan", () -> new int[]{6, 7, 3}[index[2]++]),
                        new Car("daddyking", () -> new int[]{6, 7, 8}[index[3]++])
                )
        );

        for (int i = 0; i < 3; i++) {
            carRacingExecutor.proceedNextRound();
        }

        List<String> winnerNames = carRacingExecutor
                .getCurrentWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        assertThat(winnerNames).isEqualTo(Arrays.asList("kky", "daddyking"));
    }
}
