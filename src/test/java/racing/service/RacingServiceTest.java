package racing.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racing.strategy.NumberCompareMoveStrategy.CAN_MOVE_NUMBER;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.dto.RacingInput;
import racing.dto.RacingOutput;
import racing.strategy.FixedNumberGenerator;
import racing.strategy.NumberCompareMoveStrategy;

class RacingServiceTest {

  @ParameterizedTest
  @DisplayName("차량 갯수와 시도 갯수를 받아 따라 n회 시도했을 때 레이싱 결과 총 움직인 거리 확인")
  @CsvSource(value = {"1|1|1", "2|2|4", "5|5|25", "10|10|100"}, delimiter = '|')
  void racingDistanceTest(int carCount, int attemptCount, int expected) {
    RacingInput racingInput = new RacingInput(carCount, attemptCount);
    RacingService racingService = new RacingService(
        new NumberCompareMoveStrategy(new FixedNumberGenerator(CAN_MOVE_NUMBER + 1)));

    List<RacingOutput> racingOutputs = racingService.race(racingInput);

    int distanceSum = 0;
    for (int distance: racingOutputs.get(racingOutputs.size()-1).getDistances()) {
        distanceSum += distance;
    }

    assertThat(distanceSum).isEqualTo(expected);
  }
}