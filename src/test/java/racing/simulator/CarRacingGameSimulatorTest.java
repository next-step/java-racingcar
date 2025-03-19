package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.types.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarRacingGameSimulatorTest {

  @DisplayName("생성자 테스트1")
  @Test
  void constructorTest1() {
    List<CarName> carNames = List.of(
        CarName.valueOf("pobi"),
        CarName.valueOf("crong"),
        CarName.valueOf("honux")
    );
    assertDoesNotThrow(() -> new CarRacingGameSimulator(carNames, new RandomCarMovingStrategy()));
  }

  @DisplayName("생성자 테스트2")
  @Test
  void constructorTest2() {
    assertDoesNotThrow(() -> new CarRacingGameSimulator(CarCount.valueOf(3), () -> true));
  }

  @DisplayName("시뮬레이션을 수행하면 simulateCount 만큼의 결과를 담은 리스트를 반환한다.")
  @Test
  void run_givenSimulateCount_returnLocationResult() {
    int carCount = 3;
    List<CarName> carNames = List.of(
        CarName.valueOf("pobi"),
        CarName.valueOf("crong"),
        CarName.valueOf("honux")
    );
    int simulateCount = 4;

    CarRacingGameSimulator simulatorWithCarCount = new CarRacingGameSimulator(CarCount.valueOf(carCount), () -> true);
    CarRacingGameSimulateResult simulateWithCarCountResults = Objects.requireNonNull(simulatorWithCarCount.run(SimulateCount.valueOf(simulateCount)));

    CarRacingGameSimulator simulatorWithCarNames = new CarRacingGameSimulator(carNames, () -> true);
    CarRacingGameSimulateResult simulateWithCarNamesResults = Objects.requireNonNull(simulatorWithCarNames.run(SimulateCount.valueOf(simulateCount)));

    assertAll(
        () -> assertThat(simulateWithCarCountResults.getSimulationResult()).hasSize(simulateCount),
        () -> IntStream.range(0, simulateWithCarCountResults.getSimulationResult().size())
            .forEach(i ->
                assertThat(simulateWithCarCountResults.getSimulationResult().get(i))
                    .extracting(Car::getLocation).containsOnly(i + 1)
            ),
        () -> assertThat(simulateWithCarNamesResults.getSimulationResult()).hasSize(simulateCount),
        () -> IntStream.range(0, simulateWithCarNamesResults.getSimulationResult().size())
            .forEach(i ->
                assertThat(simulateWithCarNamesResults.getSimulationResult().get(i))
                    .extracting(Car::getLocation).containsOnly(i + 1)
            )
    );
  }

  @DisplayName("시뮬레이션을 수행하면 종료 후 자동차들을 리셋한다.")
  @Test
  void run_givenSimulateCount_resetCarGroupLocation() {
    int carCount = 3;
    int simulateCount = 4;

    CarRacingGameSimulator simulatorWithCarCount = new CarRacingGameSimulator(CarCount.valueOf(carCount), () -> true);
    simulatorWithCarCount.run(SimulateCount.valueOf(simulateCount));

    CarGroup carGroup = simulatorWithCarCount.getCarGroup();

    assertThat(carGroup.copyCars()).extracting(Car::getLocation).containsOnly(0);
  }
}
