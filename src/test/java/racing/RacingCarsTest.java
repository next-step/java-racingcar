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
        assertThat(racingCars.getRacingCar(carName).getPosition()).isEqualTo(locationInt);

        RacingCars movedRacingCars =racingCars.race(new RacingGameSpec() {
            @Override
            public int moveCount() {
                return 1;
            }
        });
        assertThat(movedRacingCars.getRacingCar(carName).getPosition()).isEqualTo(locationInt + 1);
    }

    @ParameterizedTest
    @CsvSource(value = {"ato,root,trevi;0,1,2;1;trevi", "ato,root,trevi;2,2,0;2;ato"}, delimiter = ';')
    void getLeads(String carNames, String locations, Integer leaderSize, String leaderName) {
        RacingCars racingCars = RacingCars.init(carNames, locations);
        RacingCars leaders = racingCars.getLeads();

        // size check
        assertThat(leaders.getSize()).isEqualTo(leaderSize);

        // name check
        assertThat(leaders.containName(leaderName)).isEqualTo(true);
    }
}
