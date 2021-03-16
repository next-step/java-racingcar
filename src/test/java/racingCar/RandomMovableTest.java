package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomMovableTest {

  @DisplayName("0~9 난수 생성 기능")
  @Test
  void tete() {
    RandomMovable randomMovable = new RandomMovable();
    randomMovable.createRandomNumber();
    assertThat(randomMovable.getRandomNumber())
        .isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
  }

}
