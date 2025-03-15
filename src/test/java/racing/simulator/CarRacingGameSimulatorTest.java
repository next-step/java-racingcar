package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.ArgumentMatchers.anyInt;

class CarRacingGameSimulatorTest {

  @DisplayName("자동차 수 값이 1, 0, 음수일 때 CarRacingGameSimulator 생성자를 호출하면 RuntimeException을 던진다.")
  @ParameterizedTest
  @CsvSource(value = {
      "-1:1",
      "0:1",
      "1:1"
  }, delimiter = ':')
  void constructor_notPositiveNumberCarCount_throwsRuntimeException(String carCount, String simulateCount) {
    assertThrows(RuntimeException.class, () -> new CarRacingGameSimulator(
        Integer.parseInt(carCount),
        Integer.parseInt(simulateCount),
        Mockito.mock(CarMoveDecider.class))
    );
  }

  @DisplayName("시뮬레이션 수 값이 0 또는 음수일 때 CarRacingGameSimulator 생성자를 RuntimeException을 던진다.")
  @ParameterizedTest
  @CsvSource(value = {
      "2:0",
      "2:-1"
  }, delimiter = ':')
  void constructor_notPositiveNumberSimulationCount_throwsRuntimeException(String carCount, String simulateCount) {
    assertThrows(RuntimeException.class, () -> new CarRacingGameSimulator(
        Integer.parseInt(carCount),
        Integer.parseInt(simulateCount),
        Mockito.mock(CarMoveDecider.class))
    );
  }

  @DisplayName("시물레이션을 수행하면 시뮬레이션 결과를 반환한다.")
  @ParameterizedTest
  @CsvSource(value = {
      "3:2:0:",
      "3:2:1:",
      "3:1:2:",
      "3:2:3:",
      "3:2:4:--",
      "3:4:5:----",
      "3:2:6:--",
      "3:5:7:-----",
      "3:2:8:--",
      "3:2:9:--"
  }, delimiter = ':')
  void simulate_returnSimulateResult(int carCount, int simulateCount, int randomNum, String consoleOutput) {
    Random mockRandom = Mockito.mock(Random.class);
    Mockito.when(mockRandom.nextInt(anyInt())).thenReturn(randomNum);
    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, simulateCount,  new CarMoveDecider(mockRandom));

    Car[] result = simulator.simulate();

    assertAll(
        () -> assertThat(result.length).isEqualTo(carCount),
        () -> assertThat(result)
            .extracting(Car::getLocationConsoleFormat)
            .containsOnly(consoleOutput)
    );
  }

  @DisplayName("시물레이션을 여러번 수행하면 새롭게 세팅되어 시뮬레이션을 수행해 결과를 반환한다.")
  @ParameterizedTest
  @CsvSource(value = {
      "3:2:0:",
      "3:2:1:",
      "3:1:2:",
      "3:2:3:",
      "3:2:4:--",
      "3:4:5:----",
      "3:2:6:--",
      "3:5:7:-----",
      "3:2:8:--",
      "3:2:9:--"
  }, delimiter = ':')
  void simulateMultipleTimes_returnsNewSimulationResult(int carCount, int simulateCount, int randomNum, String consoleOutput) {
    Random mockRandom = Mockito.mock(Random.class);
    Mockito.when(mockRandom.nextInt(anyInt())).thenReturn(randomNum);
    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, simulateCount,  new CarMoveDecider(mockRandom));

    simulator.simulate();
    Car[] result = simulator.simulate();

    assertAll(
        () -> assertThat(result.length).isEqualTo(carCount),
        () -> assertThat(result)
            .extracting(Car::getLocationConsoleFormat)
            .containsOnly(consoleOutput)
    );
  }
}
