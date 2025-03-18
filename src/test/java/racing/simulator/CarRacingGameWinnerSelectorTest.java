package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.types.Car;
import racing.types.CarName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarRacingGameWinnerSelectorTest {

  @DisplayName("한명의 우승자가 있을 때 우승자를 요청하면 한명의 우승자를 가져온다.")
  @Test
  public void select_returnOneWinners() {
    Car winnerCar = new Car(new CarName("a"));
    winnerCar.go(() -> true);

    List<Car> input = List.of(
        winnerCar,
        new Car(new CarName("b")),
        new Car(new CarName("c"))
    );

    CarRacingGameWinnerSelector selector = new CarRacingGameWinnerSelector();

    List<Car> winners = selector.select(input);
    assertThat(winners).containsExactly(winnerCar);
  }

  @DisplayName("여러명의 우승자가 있을 때 우승자를 요청하면 여러명의의 우승자를 가져온다.")
  @Test
  public void select_returnMultipleWinners() {
    Car winnerCar1 = new Car(new CarName("a"));
    Car winnerCar2 = new Car(new CarName("b"));
    winnerCar1.go(() -> true);
    winnerCar2.go(() -> true);

    List<Car> input = List.of(
        winnerCar1,
        new Car(new CarName("c")),
        winnerCar2
    );

    CarRacingGameWinnerSelector selector = new CarRacingGameWinnerSelector();

    List<Car> winners = selector.select(input);
    assertThat(winners).containsExactly(winnerCar1, winnerCar2);
  }

}
