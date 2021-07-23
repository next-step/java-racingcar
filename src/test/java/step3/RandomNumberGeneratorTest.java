package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class RandomNumberGeneratorTest {

  @ParameterizedTest(name = "임의의 숫자 {0}은 0부터 9 사이에 있다")
  @MethodSource("randomNumberProvider")
  void generate(int randomNumber) {
    assertThat(randomNumber).isBetween(0, 9);
  }

  static IntStream randomNumberProvider() {
    final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    return IntStream.range(0, 5)
        .map(i -> randomNumberGenerator.generate());
  }
}