package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarRacingGameSimulatorTest {

  @DisplayName("run 메서드는 simulateCount 만큼의 결과를 담은 리스트를 반환하고, 종료 후 자동차를 리셋한다.")
  @Test
  void run_shouldReturnListWithSizeSimulateCountAndResetCars() {
    int carCount = 3;
    int simulateCount = 4;

    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, () -> true);

    List<List<Car>> simulationResults = simulator.run(simulateCount);
    List<Car> currentCars = simulator.copyCars();

    assertThat(simulationResults).hasSize(simulateCount);
    IntStream.range(0, simulateCount)
        .forEach(i -> {
          List<Car> result = simulationResults.get(i);
          assertThat(result)
              .extracting(Car::getLocation)
              .containsOnly(i + 1);
        });
    assertThat(currentCars)
        .extracting(Car::getLocation)
        .containsOnly(0);
  }

  @DisplayName("차들을 move 하면 전략에 따라 차를 움직인다.")
  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void tryMoveCars_carsMovedByStrategy(boolean strategyResult) {
    int carCount = 3;
    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, () -> strategyResult);

    simulator.moveCars();
    List<Car> result = simulator.copyCars();

    assertThat(result)
        .extracting(Car::getLocation)
        .containsOnly(strategyResult ? 1 : 0);
  }

  @DisplayName("차들을 copy 하면 자동차 배열의 깊은 복사를 반환한다.")
  @Test
  void copyCars_shouldReturnDeepCopiedCarArray() {
    int carCount = 3;
    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, () -> true);

    List<Car> firstCopiedCars = simulator.copyCars();
    List<Car> secondCopiedCars = simulator.copyCars();

    assertAll(
        () -> assertThat(firstCopiedCars).hasSize(carCount),
        () -> assertThat(secondCopiedCars).hasSize(carCount),
        () -> assertThat(firstCopiedCars)
            .zipSatisfy(secondCopiedCars, (element1, element2) -> assertThat(element1).isNotSameAs(element2))
    );
  }

  @DisplayName("차들을 reset 하면 차의 위치가 0이 된다.")
  @Test
  void reset_shouldSetCarPositionToZero() {
    int carCount = 3;
    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, () -> true);

    simulator.moveCars();
    simulator.resetCars();
    List<Car> result = simulator.copyCars();

    assertThat(result)
        .extracting(Car::getLocation)
        .containsOnly(0);
  }
}
