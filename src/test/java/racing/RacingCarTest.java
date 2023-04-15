package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.race.Cars;
import racing.race.Racing;
import racing.strategy.MoveNumberStrategy;
import racing.strategy.RandomNumberStrategy;
import racing.strategy.StopNumberStrategy;

public class RacingCarTest {

  Cars cars;
  Racing racing = new Racing();

  @BeforeEach
  public void init() {
    cars = new Cars();
  }

  @Test
  void 멈춤() {
    cars.ready(3);

    StopNumberStrategy stopNumberStrategy = new StopNumberStrategy();
    cars.getGameCar().get(1).move(stopNumberStrategy);

    assertThat(cars.getGameCar().get(1).moveDistance()).isEqualTo(0);
  }

  @Test
  void 전진() {
    cars.ready(3);

    MoveNumberStrategy moveNumberStrategy = new MoveNumberStrategy();
    cars.getGameCar().get(1).move(moveNumberStrategy);

    assertThat(cars.getGameCar().get(1).moveDistance()).isEqualTo(1);
  }

  @Test
  void 레이싱게임진행() {
    racing.race(cars.getGameCar(), 3);
  }

  @Test
  void 랜덤값입력() {
    RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();

    int result = randomNumberStrategy.getNumber();

    assertThat(result).isBetween(0, 9);
  }

  @Test
  void 이동횟수음수입력() {
    assertThatExceptionOfType(NumberFormatException.class)
        .isThrownBy(() -> racing.race(cars.getGameCar(), -1));
  }

  @Test
  void 자동차갯수음수입력() {
    assertThatExceptionOfType(NumberFormatException.class)
        .isThrownBy(() -> cars.ready(-1));
  }

  @Test
  void 자동차갯수입력() {
    int size = 3;

    cars.ready(size);

    assertThat(cars.getGameCar().size()).isEqualTo(3);
  }

}
