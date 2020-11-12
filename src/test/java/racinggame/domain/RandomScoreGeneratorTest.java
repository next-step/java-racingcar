package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.RandomScoreGenerator;

class RandomScoreGeneratorTest {

  @Test
  @DisplayName("동일 값 출력 확인")
  void equalityTest() {
    RandomScoreGenerator randomScoreGenerator = new RandomScoreGenerator(0);
    RandomScoreGenerator randomScoreGenerator1 = new RandomScoreGenerator(0);

    int numTry = 10;

    List<Integer> result = new ArrayList<>();
    List<Integer> result1 = new ArrayList<>();

    for (int i = 0; i < numTry; i++) {
      result.add(randomScoreGenerator.generateScore());
      result1.add(randomScoreGenerator1.generateScore());
    }

    assertThat(result).isEqualTo(result1);
  }

  @Test
  @DisplayName("매번 다른 값 출력하는 지 테스트")
  void diverseOutput() {
    RandomScoreGenerator randomScoreGenerator = new RandomScoreGenerator();
    RandomScoreGenerator randomScoreGenerator1 = new RandomScoreGenerator();

    int numTry = 100;

    List<Integer> result = new ArrayList<>();
    List<Integer> result1 = new ArrayList<>();

    for (int i = 0; i < numTry; i++) {
      result.add(randomScoreGenerator.generateScore());
      result1.add(randomScoreGenerator1.generateScore());
    }

    assertThat(result).isNotEqualTo(result1);
  }

}
