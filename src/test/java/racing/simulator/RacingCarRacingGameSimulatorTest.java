package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.types.CarCount;
import racing.types.SimulateCount;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarRacingGameSimulatorTest {

  @DisplayName("시뮬레이션을 수행하면 simulateCount 만큼의 결과를 담은 리스트를 반환하고, 종료 후 자동차를 리셋한다.")
  @Test
  void run_givenSimulateCount_returnLocationResult() {
    int carCount = 3;
    int simulateCount = 4;

    CarRacingGameSimulator simulator = new CarRacingGameSimulator(new CarCount(carCount), () -> true);

    List<List<Integer>> simulateResults = Objects.requireNonNull(simulator.run(new SimulateCount(simulateCount)));

    assertAll(
        () -> assertThat(simulateResults).hasSize(simulateCount),
        () -> IntStream.range(0, simulateResults.size())
            .forEach(i -> assertThat(simulateResults.get(i)).containsOnly(i + 1))
    );
  }
}
