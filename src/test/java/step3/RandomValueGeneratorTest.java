package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomValueGeneratorTest {

  @Test
  @DisplayName("랜덤숫자(0~9) 생성 테스트")
  void getRandomNumberTest() {
    for (int i = 0; i < 100; i++) {
      assertThat(RandomValueGenerator.getRandomNumber()).isBetween(0, 9);
    }
  }
}