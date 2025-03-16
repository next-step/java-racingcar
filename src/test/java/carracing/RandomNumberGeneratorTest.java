package carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RandomNumberGeneratorTest {
  private static final Set<Integer> VALID_RANDOM_NUMBERS = new HashSet<>(Arrays.asList(
          0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

  @DisplayName("0-9 사이 랜덤 숫자 생성 테스트")
  @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
  void testGenerateRandomNumber() {
    int actual = RandomNumberGenerator.generate();
    Assertions.assertTrue(VALID_RANDOM_NUMBERS.contains(actual));
  }
}