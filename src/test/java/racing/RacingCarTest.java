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
  private static final int TRY_NUMBER = 5;

  @BeforeEach
  public void init() {
    cars = new Cars("pobi,crong,honux");
  }

  @Test
  void 우승자는0명일수없다() {
    cars.race(TRY_NUMBER);

    assertThat(cars.getWinnerCars().size()).isGreaterThan(0);
  }

  @Test
  void 자동차이름은5자를초과할수없다() {
    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
        .isThrownBy(() -> {
          cars = new Cars("pobipobi,crong,honux");
        });
  }

  @Test
  void 멈춤() {
    StopNumberStrategy stopNumberStrategy = new StopNumberStrategy();
    cars.getGameCars().get(1).move(stopNumberStrategy);

    assertThat(cars.getGameCars().get(1).moveDistance()).isEqualTo(0);
  }

  @Test
  void 전진() {
    MoveNumberStrategy moveNumberStrategy = new MoveNumberStrategy();
    cars.getGameCars().get(1).move(moveNumberStrategy);

    assertThat(cars.getGameCars().get(1).moveDistance()).isEqualTo(1);
  }

  @Test
  void 레이싱게임진행() {
    cars.race(TRY_NUMBER);
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
        .isThrownBy(() -> cars.race(-1));
  }

  @Test
  void 자동차갯수입력() {
    assertThat(cars.getGameCars().size()).isEqualTo(CAR_NUMBER);
  }

}
