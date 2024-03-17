package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositiveNumberTest {
  @Test
  void 입력이_참이면_앞으로_이동() {
    PositiveNumber positiveNumber = new PositiveNumber(0);
    positiveNumber.increaseConditionally(true);
    assertThat(positiveNumber).isEqualTo(new PositiveNumber(1));
  }

  @Test
  void 입력이_거짓이면_이동_안함() {
    PositiveNumber positiveNumber = new PositiveNumber(0);
    positiveNumber.increaseConditionally(false);
    assertThat(positiveNumber).isEqualTo(new PositiveNumber(0));
  }

  @Test
  void 입력보다_더_크면_참() {
    assertThat(new PositiveNumber(5).largerThan(new PositiveNumber(3))).isTrue();
  }

  @Test
  void 입력보다_더_가까우면_참() {
    assertThat(new PositiveNumber(3).smallerThan(new PositiveNumber(5)));
  }
}
