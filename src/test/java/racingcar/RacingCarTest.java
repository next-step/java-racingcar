package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 경주의 핵심 로직을 테스트한다.")
public class RacingCarTest {

  @Test
  void 랜덤값이_0과_9_사이이다() {
    RandomUtil randomUtil = new RandomUtil();
    assertThat(randomUtil.getRandomValue()).isBetween(0, 9);
  }

  @Test
  void 랜덤값이_4이상일때_전진한다() {
    //
  }
}
