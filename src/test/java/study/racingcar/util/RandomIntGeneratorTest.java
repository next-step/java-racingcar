package study.racingcar.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomIntGeneratorTest {


  @DisplayName("입력받은 범위 내의 난수를 생성합니다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void generateMaxBound_randomInt_maxBound(int input) {
    int num = RandomIntGenerator.generateMaxBound(input);

    assertThat(num).isLessThan(input);
  }
}
