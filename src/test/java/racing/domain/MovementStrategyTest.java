package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;


class MovementStrategyTest {
  @RepeatedTest(100)
  @DisplayName("0~9 범위의 난수를 생성한다")
  void generateRandomNumberBetween0And9() {
    MovementStrategy movement = new MovementStrategy(0, 9);
    int result = movement.generate();
    assertThat(result).isBetween(0, 9);
  }

  @RepeatedTest(100)
  @DisplayName("4~4 범위(단일 값)의 난수를 생성한다")
  void generateRandomNumberWithSingleValue() {
    MovementStrategy movement = new MovementStrategy(4, 4);
    int result = movement.generate();
    assertThat(result).isEqualTo(4);
  }

  @RepeatedTest(100)
  @DisplayName("다양한 범위의 난수를 생성한다")
  void generateRandomNumberInDifferentRanges() {
    MovementStrategy movement = new MovementStrategy(5, 15);
    int result = movement.generate();
    assertThat(result).isBetween(5, 15);
  }

}