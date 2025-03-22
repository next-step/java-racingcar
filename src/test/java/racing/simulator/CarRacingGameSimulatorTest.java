package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.types.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    int simulateCount = 3;

    CarRacingGameSimulator simulatorWithCarCount = new CarRacingGameSimulator(CarCount.valueOf(carCount), () -> true);
    CarRacingGameSimulateResult simulateWithCarCountResults = simulatorWithCarCount.run(SimulateCount.valueOf(simulateCount));

    CarRacingGameSimulator simulatorWithCarNames = new CarRacingGameSimulator(carNames, () -> true);
    CarRacingGameSimulateResult simulateWithCarNamesResults = simulatorWithCarNames.run(SimulateCount.valueOf(simulateCount));

    CarRacingGameSimulateResult expectSimulateWithCarCountResults = CarRacingGameSimulateResult.valueOf(
        List.of(
            new CarGroup(
                List.of(
                    Car.valueOf(new CarLocation(1)),
                    Car.valueOf(new CarLocation(1)),
                    Car.valueOf(new CarLocation(1))
                )
            ),
            new CarGroup(
                List.of(
                    Car.valueOf(new CarLocation(2)),
                    Car.valueOf(new CarLocation(2)),
                    Car.valueOf(new CarLocation(2))
                )
            ),
            new CarGroup(
                List.of(
                    Car.valueOf(new CarLocation(3)),
                    Car.valueOf(new CarLocation(3)),
                    Car.valueOf(new CarLocation(3))
                )
            )
        )
    );

    CarRacingGameSimulateResult expectSimulateWithCarNamesResults = CarRacingGameSimulateResult.valueOf(
        List.of(
            new CarGroup(
                List.of(
                    Car.valueOf(CarName.valueOf("pobi"), new CarLocation(1)),
                    Car.valueOf(CarName.valueOf("crong"), new CarLocation(1)),
                    Car.valueOf(CarName.valueOf("honux"), new CarLocation(1))
                )
            ),
            new CarGroup(
                List.of(
                    Car.valueOf(CarName.valueOf("pobi"), new CarLocation(2)),
                    Car.valueOf(CarName.valueOf("crong"), new CarLocation(2)),
                    Car.valueOf(CarName.valueOf("honux"), new CarLocation(2))
                )
            ),
            new CarGroup(
                List.of(
                    Car.valueOf(CarName.valueOf("pobi"), new CarLocation(3)),
                    Car.valueOf(CarName.valueOf("crong"), new CarLocation(3)),
                    Car.valueOf(CarName.valueOf("honux"), new CarLocation(3))
                )
            )
        )
    );

    assertThat(simulateWithCarCountResults).isEqualTo(expectSimulateWithCarCountResults);
    assertEquals(simulateWithCarNamesResults, expectSimulateWithCarNamesResults);
  }

}
