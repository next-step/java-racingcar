package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.RacingResultDTO;
import racingcar.dto.RacingWrapResultDTO;

public class RacingCarSimulatorTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("결과는 입력한 트라이 횟수와 같은 수의 wrapResult를 가집니다")
    void wrapResultsSizeTest(int tryNumber) {
        RacingResultDTO result = RacingCarSimulator.simulate(1, tryNumber);
        Assertions.assertEquals(tryNumber, result.wrapResults.length);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("wrapResult는 입력한 차의 수와 같은 수의 차량 상태를 가집니다")
    void carStateSizeTest(int carNumber) {
        RacingResultDTO result = RacingCarSimulator.simulate(carNumber, 1);
        RacingWrapResultDTO[] wrapResults = result.wrapResults;
        for (RacingWrapResultDTO wrapResult : wrapResults) {
            Assertions.assertEquals(carNumber, wrapResult.carStates.carStates.length);
        }
    }
}
