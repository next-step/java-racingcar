package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.Car;
import racingCar.RacingCar;
import racingCar.RacingCarConfiguration;
public class RacingCarTest {
    @ParameterizedTest
    @CsvSource(value = "pobi,woni,jun | 5", delimiter = '|')
    void racingCar(String participant, Integer trial) {
        RacingCar racingCar = new RacingCar(participant);
        racingCar.setTrial(trial);
        racingCar.run();
        racingCar.showWinner();
    }
}
