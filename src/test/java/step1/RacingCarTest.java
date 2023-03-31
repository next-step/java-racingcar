package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarTest {
    @ParameterizedTest
    @CsvSource(value = "kris,lina,duke | 5", delimiter = '|')
    void racingCar(String participant, Integer trial) {
        RacingCar racingCar = new RacingCar(participant);
        racingCar.setTrial(trial);
        racingCar.run();
        racingCar.showWinner();
    }
}
