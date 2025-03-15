package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyInt;

class CarRacingGameSimulatorTest {

  @DisplayName("차들을 move 하려고 시도하면 랜덤 값에 따라 움직이거나 움직이지 않는다.")
  @ParameterizedTest
  @CsvSource(value = {
      "5:0:''",
      "6:1:''",
      "7:2:''",
      "15:3:''",
      "10:4:-",
      "2:5:-",
      "3:6:-",
      "8:7:-",
      "9:8:-",
      "19:9:-"
  }, delimiter = ':')
  void tryMoveCars_carMoveOrStayBasedOnRandomValue(int carCount, int randomNum, String consoleOutput) {
    Random mockRandom = Mockito.mock(Random.class);
    Mockito.when(mockRandom.nextInt(anyInt())).thenReturn(randomNum);
    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, new CarMoveDecider(mockRandom));

    simulator.tryMoveCars();
    Car[] result = simulator.copyCars();

    assertThat(result)
        .extracting(Car::getLocationConsoleFormat)
        .containsOnly(consoleOutput);
  }

  @DisplayName("차를 move 하려고 시도하면 랜덤 값에 따라 움직이거나 움직이지 않는다.")
  @ParameterizedTest
  @CsvSource(value = {
      "0:''",
      "1:''",
      "2:''",
      "3:''",
      "4:-",
      "5:-",
      "6:-",
      "7:-",
      "8:-",
      "9:-"
  }, delimiter = ':')
  void tryMoveCar_carMoveOrStayBasedOnRandomValue(int randomNum, String consoleOutput) {
    int carCount = 3;
    Random mockRandom = Mockito.mock(Random.class);
    Mockito.when(mockRandom.nextInt(anyInt())).thenReturn(randomNum);
    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, new CarMoveDecider(mockRandom));

    Car car = new Car();
    simulator.tryMoveCar(car);
    assertThat(car)
        .extracting(Car::getLocationConsoleFormat)
        .isEqualTo(consoleOutput);
  }

  @DisplayName("차들을 copy 하면 자동차 배열의 깊은 복사를 반환한다.")
  @Test
  void copyCars_shouldReturnDeepCopiedCarArray() {
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
      "5:0",
      "6:1",
      "10:2",
      "12:3",
      "6:4",
      "3:5",
      "8:6",
      "12:7",
      "15:8",
      "4:9"
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
