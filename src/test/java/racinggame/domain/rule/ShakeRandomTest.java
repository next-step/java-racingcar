package racinggame.domain.rule;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ShakeRandomTest {

  @ParameterizedTest
  @CsvSource(value = {"10:0:9", "20:0:19"}, delimiter = ':')
  @DisplayName("출력결과가 0<=출력결과<shakeBound를 만족하는 정수인가?")
  void shakeRandomBoundTest(int shakeBound, int min, int max) {
    int start = 0;
    int end = 10000;
    ShakeRandom shakeRandom = new ShakeRandom(shakeBound);
    IntStream.range(start, end).forEach(index -> assertThat(shakeRandom.shakeShake()).isBetween(min, max));
  }

}