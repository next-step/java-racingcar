package racingcar.business;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux / 5"}, delimiter = '/')
    void initializeAndStartAndGetRecordingHistory(String carNames, int countOfMovesAttemps) {
        Racing racing = Racing.of(carNames, countOfMovesAttemps);
        racing.start();
        Racing.Recording recordingData = racing.getRecordingData();

        List<Map<String, Integer>> racingHistory = recordingData.getRacingHistory();

        racingHistory.forEach(
                history -> assertThat(history).containsKeys(
                        Car.of("pobi", null).getName(),
                        Car.of("crong", null).getName(),
                        Car.of("honux", null).getName()
                )
        );
    }
}
