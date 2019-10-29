package racingcar.business;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @ParameterizedTest
    @CsvSource(value = {"3, 5"}, delimiter = ',')
    void initializeAndStartAndGetRecordingHistory(int countOfCars, int countOfMovesAttemps) {
        Racing racing = Racing.of(countOfCars, countOfMovesAttemps);
        racing.start();
        Racing.Recording recordingData = racing.getRecordingData();

        List<Map<String, Integer>> racingHistory = recordingData.getRacingHistory();

        racingHistory.forEach(
                history -> assertThat(history).containsKeys(
                        Car.of(CarName.get(0)).getName(),
                        Car.of(CarName.get(1)).getName(),
                        Car.of(CarName.get(2)).getName()
                ));
    }
}
