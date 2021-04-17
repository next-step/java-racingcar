package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.validator.RandomNumber;

public class RandomNumberTest {

  @DisplayName("랜덤 숫자가 10보다 작은지 테스트")
  @Test
  void randomNumberLessTanTest() {
    // given
    // when
    int conditionNumber = RandomNumber.generator();

    // then
    assertThat(conditionNumber).isLessThan(10);
  }

  @DisplayName("랜덤 숫자가 0보다 큰지 테스트")
  @Test
  void randomNumberGreaterThanTest() {
    // given
    // when
    int conditionNumber = RandomNumber.generator();

    // then
    assertThat(conditionNumber).isGreaterThan(0);
  }

}
