package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.CarRace;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceTest {

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"2,2", "4,5", "1,3"})
    @DisplayName("자동차 경주를 실행하면, 시도 횟수 동안의 자동차의 위치를 반환한다.")
    void runCarRaceAndGetResult(int carCount, int runCount) {
        CarRace carRace = new CarRace(carCount, runCount);
        List<List<Integer>> result = carRace.run();

        assertThat(result)
                .hasSize(runCount)
                .allMatch(list -> list.size() == carCount);
    }

}
