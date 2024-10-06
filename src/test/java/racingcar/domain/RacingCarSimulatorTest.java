package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.RacingResultDTO;
import racingcar.dto.RacingWinnersDTO;
import racingcar.dto.RacingWrapResultDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarSimulatorTest {
    @Test
    @DisplayName("입력한 트라이 횟수가 0이면 초기 상태 wrapResult만 가집니다.")
    void wrapResultsSizeTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        RacingResultDTO result = RacingCarSimulator.simulate(carNames, 0);
        assertThat(result.getWrapResults().getWrapResults().size()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("결과는 입력한 트라이 횟수보다 하나 많은 수의 wrapResult를 가집니다")
    void wrapResultsSizeTest(int tryNumber) {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        RacingResultDTO result = RacingCarSimulator.simulate(carNames, tryNumber);
        assertThat(result.getWrapResults().getWrapResults().size()).isEqualTo(tryNumber + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("wrapResult는 입력한 차의 수와 같은 수의 차량 상태를 가집니다")
    void carStateSizeTest(int carNumber) {
        List<String> carNames = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            carNames.add("car" + i);
        }
        RacingResultDTO result = RacingCarSimulator.simulate(carNames, 1);
        List<RacingWrapResultDTO> wrapResults = result.getWrapResults().getWrapResults();
        for (RacingWrapResultDTO wrapResult : wrapResults) {
            assertThat(wrapResult.getCarStates().getCarStates().size()).isEqualTo(carNumber);
        }
    }

    @Test
    @DisplayName("racingResults는 1명 이상의 승자 리스트를 가집니다.")
    void hasWinnerTest() {
        List<String> carNames = new ArrayList<>(Arrays.asList("Car1", "Car2", "Car3"));
        RacingResultDTO result = RacingCarSimulator.simulate(carNames, 1);
        RacingWinnersDTO winners = result.getWinners();
        assertThat(winners.getWinners()).isNotEmpty();
    }
}
