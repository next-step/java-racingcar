package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingRecordCarsTest {

    @ParameterizedTest
    @CsvSource(value = {"ato,root,trevi;0,1,2;1;trevi", "ato,root,trevi;2,2,0;2;ato"}, delimiter = ';')
    void getLeads(String carNames, String locations, Integer leaderSize, String leaderName) {
        RacingCars racingCars = RacingCars.init(carNames, locations);
        RacingRecordCars racingRecordCars = RacingRecordCars.init(racingCars);
        RacingRecordCars leaders = racingRecordCars.getLeads();

        // size check
        assertThat(leaders.getSize()).isEqualTo(leaderSize);

        // name check
        assertThat(leaders.containName(leaderName)).isEqualTo(true);
    }
}
