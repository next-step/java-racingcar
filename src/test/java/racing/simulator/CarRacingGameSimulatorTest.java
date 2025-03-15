package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;

class CarRacingGameSimulatorTest {

  @DisplayName("자동차 수 값이 1, 0, 음수일 때 CarRacingGameSimulator 생성자를 호출하면 RuntimeException을 던진다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, -1})
  void constructor_notPositiveNumberCarCount_throwsRuntimeException(int carCount) {
    assertThrows(RuntimeException.class, () -> new CarRacingGameSimulator(
        carCount,
        Mockito.mock(CarMoveDecider.class))
    );
  }

  @DisplayName("자동차 수 값이 1, 0, 음수일 때 검증 로직을 호출하면 RuntimeException을 던진다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, -1})
  void isNotValidCarCount_notPositiveNumberCarCount_returnTrue(int carCount) {
    assertThrows(RuntimeException.class, () -> CarRacingGameSimulator.checkNotValidCarCount(carCount));
  }

  @DisplayName("시뮬레이션 수 값이 0 또는 음수일 때 검증 로직을 호출하면 RuntimeException을 던진다.")
  @ParameterizedTest
  @ValueSource(ints = {0, -1})
  void isNotSimulateCount_notPositiveNumberSimulationCount_returnTrue(int simulateCount) {
    assertThrows(RuntimeException.class, () -> CarRacingGameSimulator.checkNotValidSimulateCount(simulateCount));
  }


  @DisplayName("차들을 move 하려고 시도하면 랜덤 값에 따라 움직이거나 움직이지 않는다.")
  @ParameterizedTest
  @CsvSource(value = {
      "3:0:''",
      "3:1:''",
      "3:2:''",
      "3:3:''",
      "3:4:-",
      "3:5:-",
      "3:6:-",
      "3:7:-",
      "3:8:-",
      "3:9:-"
  }, delimiter = ':')
  void tryMove_carMoveOrStayBasedOnRandomValue(int carCount, int randomNum, String consoleOutput) {
    Random mockRandom = Mockito.mock(Random.class);
    Mockito.when(mockRandom.nextInt(anyInt())).thenReturn(randomNum);
    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, new CarMoveDecider(mockRandom));

    simulator.tryMoveCars();
    Car[] result = simulator.copyCars();

    assertThat(result)
        .extracting(Car::getLocationConsoleFormat)
        .containsOnly(consoleOutput);
  }

  @DisplayName("차들을 copy 하면 자동차 배열의 깊은 복사를 반환한다.")
  @Test
  void copyCars_ShouldReturnDeepCopiedCarArray() {
    int carCount = 3;
    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, Mockito.mock(CarMoveDecider.class));

    Car[] firstCopiedCars = simulator.copyCars();
    Car[] secondCopiedCars = simulator.copyCars();

    assertAll(
        () -> assertThat(firstCopiedCars).hasSize(carCount),
        () -> assertThat(secondCopiedCars).hasSize(carCount),
        () -> {
          for (int i = 0; i < carCount; i++) {
            assert firstCopiedCars != null;
            assert secondCopiedCars != null;
            assertThat(firstCopiedCars[i]).isNotSameAs(secondCopiedCars[i]);
          }
        }
    );
  }

  @DisplayName("차들을 reset 하면 차의 위치가 0이 된다.")
  @ParameterizedTest
  @CsvSource(value = {
      "3:0",
      "3:1",
      "3:2",
      "3:3",
      "3:4",
      "3:5",
      "3:6",
      "3:7",
      "3:8",
      "3:9"
  }, delimiter = ':')
  void reset_shouldSetCarPositionToZero(int carCount, int randomNum) {
    Random mockRandom = Mockito.mock(Random.class);
    Mockito.when(mockRandom.nextInt(anyInt())).thenReturn(randomNum);
    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, new CarMoveDecider(mockRandom));

    simulator.tryMoveCars();
    simulator.resetCars();
    Car[] result = simulator.copyCars();

    assertThat(result)
        .extracting(Car::getLocationConsoleFormat)
        .containsOnly("");
  }
}
