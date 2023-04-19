package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.race.Cars;
import racing.strategy.MoveNumberStrategy;
import racing.strategy.RandomNumberStrategy;
import racing.strategy.StopNumberStrategy;

public class RacingCarTest {

  Cars cars;
  private static final int CAR_NUMBER = 3;

  @BeforeEach
  public void init() {
    cars = new Cars(CAR_NUMBER);
  }

  @Test
  void 멈춤() {
    StopNumberStrategy stopNumberStrategy = new StopNumberStrategy();
    cars.getGameCar().get(1).move(stopNumberStrategy);

    assertThat(cars.getGameCar().get(1).moveDistance()).isEqualTo(0);
  }

  @Test
  void 전진() {
    MoveNumberStrategy moveNumberStrategy = new MoveNumberStrategy();
    cars.getGameCar().get(1).move(moveNumberStrategy);

    assertThat(cars.getGameCar().get(1).moveDistance()).isEqualTo(1);
  }

  @Test
  void 레이싱게임진행() {
    cars.race(cars.getGameCar(), 3);
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
        .isThrownBy(() -> cars.race(cars.getGameCar(), -1));
  }

  @Test
  void 자동차갯수음수입력() {
    assertThatExceptionOfType(NumberFormatException.class)
        .isThrownBy(() -> new Cars(-1));
  }

  @Test
  void 자동차갯수입력() {
    assertThat(cars.getGameCar().size()).isEqualTo(CAR_NUMBER);
  }

}
