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

        assertThat(racingGame.cars).hasSize(numberOfCar);
    }


}
