package racing.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

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

  // TODO move()에서 전략을 매개변수로 받지 않고 Car를 생성할 때 이 자동차는 랜덤값으로 전진하는 자동차야. 같은 개념으로 상태로 들고 있게
  @Test
  void 레이싱게임진행() {
    cars.race(TRY_NUMBER);
  }

  @Test
  void 이동횟수는음수를입력할수없다() {
    assertThatExceptionOfType(NumberFormatException.class)
        .isThrownBy(() -> cars.race(-1));
  }

  @Test
  void 자동차생성할수있다() {
    assertThat(cars.getGameCars().size()).isEqualTo(CAR_NUMBER);
  }

}