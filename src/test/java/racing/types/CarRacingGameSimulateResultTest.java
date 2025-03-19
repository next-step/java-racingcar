package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRacingGameSimulateResultTest {

  @DisplayName("생성자 호출 시 시뮬레이션 결과에 null이 들어가면 RuntimeException을 던진다.")
  @Test
  public void constructor_givenNull_throwRuntimeException() {
    assertThatThrownBy(() -> new CarRacingGameSimulateResult(null))
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("시뮬레이션 결과는 null이 들어갈 수 없습니다.");
  }

  @DisplayName("생성자 호출 시 한 라운드의 결과에 null이 있으면 RuntimeException을 던진다.")
  @Test
  public void constructor_givenNullRoundResult_throwRuntimeException() {
    List<List<Car>> simulationResult = new ArrayList<>();
    simulationResult.add(null);
    assertThatThrownBy(() -> new CarRacingGameSimulateResult(simulationResult))
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("시뮬레이션 각 라운드 결과에서 null이 들어갈 수 없습니다.");
  }

  @DisplayName("생성자 호출 시 한 라운드의 결과에 빈 결과가 있으면 RuntimeException을 던진다.")
  @Test
  public void constructor_givenEmptyRoundResult_throwRuntimeException() {
    assertThatThrownBy(() -> new CarRacingGameSimulateResult(List.of(Collections.emptyList())))
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("시뮬레이션 각 라운드 결과에서 빈 결과가 들어갈 수 없습니다.");
  }

  @DisplayName("한명의 우승자가 있을 때 우승자를 요청하면 한명의 우승자를 가져온다.")
  @Test
  public void getWinner_returnOneWinners() {
    Car firstRoundCar1 = Car.valueOf(CarName.valueOf("a"));
    firstRoundCar1.go(() -> true);

    List<Car> firstRoundResult = List.of(
        firstRoundCar1,
        Car.valueOf(CarName.valueOf("b")),
        Car.valueOf(CarName.valueOf("c"))
    );

    Car secondCountCar1 = Car.valueOf(CarName.valueOf("a"));
    secondCountCar1.go(() -> true);
    secondCountCar1.go(() -> true);

    List<Car> secondRoundResult = List.of(
        secondCountCar1,
        Car.valueOf(CarName.valueOf("b")),
        Car.valueOf(CarName.valueOf("c"))
    );

    CarRacingGameSimulateResult simulateResult = new CarRacingGameSimulateResult(
        List.of(firstRoundResult, secondRoundResult)
    );

    assertThat(simulateResult.getWinner()).containsExactly(secondCountCar1);
  }

  @DisplayName("여러명의 우승자가 있을 때 우승자를 요청하면 여러명의의 우승자를 가져온다.")
  @Test
  public void getWinner_returnMultipleWinners() {
    Car firstRoundCar1 = Car.valueOf(CarName.valueOf("a"));
    firstRoundCar1.go(() -> true);
    Car firstRoundCar2 = Car.valueOf(CarName.valueOf("b"));
    firstRoundCar2.go(() -> true);

    List<Car> firstRoundResult = List.of(
        firstRoundCar1,
        firstRoundCar2,
        Car.valueOf(CarName.valueOf("c"))
    );

    Car secondCountCar1 = Car.valueOf(CarName.valueOf("a"));
    secondCountCar1.go(() -> true);
    secondCountCar1.go(() -> true);

    Car secondCountCar2 = Car.valueOf(CarName.valueOf("b"));
    secondCountCar2.go(() -> true);
    secondCountCar2.go(() -> true);

    List<Car> secondRoundResult = List.of(
        secondCountCar1,
        secondCountCar2,
        Car.valueOf(CarName.valueOf("c"))
    );

    CarRacingGameSimulateResult simulateResult = new CarRacingGameSimulateResult(
        List.of(firstRoundResult, secondRoundResult)
    );

    assertThat(simulateResult.getWinner()).containsExactly(secondCountCar1, secondCountCar2);
  }
}
