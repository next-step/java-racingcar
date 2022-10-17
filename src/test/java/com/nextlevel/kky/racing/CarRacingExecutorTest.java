package com.nextlevel.kky.racing;

import com.nextlevel.kky.racing.core.Car;
import com.nextlevel.kky.racing.core.CarRacingExecutor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingExecutorTest {

    public static int notAFunction() {
        throw new RuntimeException("do not call it!");
    }

    @Test
    void getWinnersTest() {
        CarRacingExecutor carRacingExecutor = new CarRacingExecutor(
                Arrays.asList(
                        new Car("kky", CarRacingExecutorTest::notAFunction, 3),
                        new Car("kdy", CarRacingExecutorTest::notAFunction, 1),
                        new Car("poltan", CarRacingExecutorTest::notAFunction, 2),
                        new Car("daddyking", CarRacingExecutorTest::notAFunction, 3)
                )
        );

        List<String> winnerNames = carRacingExecutor.getCurrentWinners();

        assertThat(winnerNames).isEqualTo(Arrays.asList("kky", "daddyking"));
    }
}
