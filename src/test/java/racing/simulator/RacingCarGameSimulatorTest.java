package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.types.Car;
import racing.types.CarCount;
import racing.types.CarName;
import racing.types.SimulateCount;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarGameSimulatorTest {

  @DisplayName("시뮬레이션을 수행하면 simulateCount 만큼의 결과를 담은 리스트를 반환하고, 종료 후 자동차를 리셋한다.")
  @Test
  void run_givenSimulateCount_returnLocationResult() {
    int carCount = 3;
    List<CarName> carNames = List.of(
        new CarName("pobi"),
        new CarName("crong"),
        new CarName("honux")
    );
    int simulateCount = 4;

    CarRacingGameSimulator simulatorWithCarCount = new CarRacingGameSimulator(new CarCount(carCount), () -> true);
    List<List<Car>> simulateWithCarCountResults = Objects.requireNonNull(simulatorWithCarCount.run(new SimulateCount(simulateCount)));

    CarRacingGameSimulator simulatorWithCarNames = new CarRacingGameSimulator(carNames, () -> true);
    List<List<Car>> simulateWithCarNamesResults = Objects.requireNonNull(simulatorWithCarNames.run(new SimulateCount(simulateCount)));

    assertAll(
        () -> assertThat(simulateWithCarCountResults).hasSize(simulateCount),
        () -> IntStream.range(0, simulateWithCarCountResults.size())
            .forEach(i -> assertThat(simulateWithCarCountResults.get(i)).extracting(Car::getLocation).containsOnly(i + 1)),
        () -> assertThat(simulateWithCarNamesResults).hasSize(simulateCount),
        () -> IntStream.range(0, simulateWithCarNamesResults.size())
            .forEach(i -> assertThat(simulateWithCarNamesResults.get(i)).extracting(Car::getLocation).containsOnly(i + 1))
    );
  }
}
