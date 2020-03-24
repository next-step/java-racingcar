package carRacing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {


    @ParameterizedTest
    @ValueSource(strings = {"1 2", "2 3", "3 4", "4 5"})
    void setCars(String input) {
        String[] inputs = input.split(" ");
        int numberOfCar = Integer.parseInt(inputs[0]);
        int time = Integer.parseInt(inputs[1]);
        RacingGame racingGame = new RacingGame(numberOfCar, time);


        assertThat(racingGame.vehicles).hasSize(numberOfCar);
    }


    @ParameterizedTest
    @CsvSource(value = {"1 2 4:1", "2 3 0:0", "3 4 2:0", "4 5 9:1"}, delimiter = ':')
    void moveTest(String input, String expected) {
        String[] inputs = input.split(" ");
        int numberOfCar = Integer.parseInt(inputs[0]);
        int time = Integer.parseInt(inputs[1]);
        RacingGame racingGame = new RacingGame(numberOfCar, time);

        MoveStrategy moveRandom = new MoveRandom(new Random() {
            @Override
            public int nextInt(int bound) {
                return Integer.parseInt(inputs[2]);
            }
        });

        racingGame.start(moveRandom);

        assertThat(racingGame.observe().stream().allMatch(i -> (i == (Integer.parseInt(expected)*time)))).isTrue();
    }

}
