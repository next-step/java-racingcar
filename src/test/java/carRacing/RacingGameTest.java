package carRacing;

import carRacing.Domain.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {


    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "pobi,crong:2", "pobi:1"}, delimiter = ':')
    void setCars(String input, String expected) {
        MoveStrategy moveRandom = new MoveRandom(new Random());

        RacingGame racingGame = new RacingGame(input, VehicleType.CAR);
        Vehicles cars = racingGame.registerVehicles(moveRandom);

        assertThat(cars.getVehicles()).hasSize(Integer.parseInt(expected));
    }


    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux 4:2", "pobi,crong 0:1", "pobi 2:1", "pobi 9:2"}, delimiter = ':')
    void moveTest(String input, String expected) {
        String[] inputs = input.split(" ");
        String player = inputs[0];
        MoveStrategy moveRandom = new MoveRandom(new Random() {
            @Override
            public int nextInt(int bound) {
                return Integer.parseInt(inputs[1]);
            }
        });
        RacingGame racingGame = new RacingGame(player, VehicleType.CAR);

        Vehicles cars = racingGame.registerVehicles(moveRandom);
        cars = racingGame.rotate(cars);

        assertThat(cars.getVehicles()).extracting(Vehicle::inquiryPosition).allSatisfy(position -> {
            assertThat(position).isEqualTo(Integer.parseInt(expected));
        });
    }

}
