package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @ParameterizedTest
    @CsvSource(value = {"root;0", "trevi;3"}, delimiter = ';')
    void race(String carName, String location) {
        Integer locationInt = Integer.parseInt(location);
        RacingCars racingCars = RacingCars.init(carName, location);
        assertThat(racingCars.getRacingCar(carName).get().getPosition()).isEqualTo(locationInt);

        RacingCars movedRacingCars =racingCars.race(new RacingGameSpec() {
            @Override
            public int moveCount() {
                return 1;
            }
        });
        assertThat(movedRacingCars.getRacingCar(carName).get().getPosition()).isEqualTo(locationInt + 1);
    }
}
