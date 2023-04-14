package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.race.Cars;
import racing.race.Racing;
import racing.util.RandomUtil;

public class RacingCarTest {

  private static Cars cars;
  Racing racing = new Racing();

  @BeforeEach
  public void init() {
    cars = new Cars();
  }

  // TODO 전략패턴..
  @Test
  void 전진() {
    cars.ready(3);
    cars.getGameCar().get(1).move();
  }

  @Test
  void 레이싱게임진행() {
    racing.race(cars.getGameCar(), 3);
  }

  @Test
  void 랜덤값입력() {
    int result = RandomUtil.getRandomValue();
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
