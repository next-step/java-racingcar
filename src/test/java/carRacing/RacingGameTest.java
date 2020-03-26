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
    @ValueSource(strings = {"pobi,crong,honux", "pobi,crong", "pobi"})
    void setCars(int input) {
        MoveStrategy moveRandom = new MoveRandom(new Random());

        RacingGame racingGame = new RacingGame(input, VehicleType.CAR);
        List<Vehicle> cars = racingGame.registerVehicles(moveRandom);

        assertThat(cars).hasSize(input);
    }


    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux 4:1", "pobi,crong 0:0", "pobi 2:0", "pobi 9:1"}, delimiter = ':')
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

        List<Vehicle> cars = racingGame.registerVehicles(moveRandom);
        cars = racingGame.rotate(cars);

        assertThat(cars).extracting(Vehicle::inquiryPosition).allSatisfy(position -> {
            assertThat(position).isEqualTo(Integer.parseInt(expected));
        });
    }

}
