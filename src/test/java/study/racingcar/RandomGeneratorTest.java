package study.racingcar;

import java.util.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomGeneratorTest {

    @DisplayName("0에서 9 사이에서 random 값 생성")
    @RepeatedTest(100)
    void generateRandomValueBetweenZeroToNine() {
        RandomGenerator randomGenerator = new RandomGenerator(new Random());
        Assertions.assertThat(randomGenerator.number()).isBetween(1, 10);
    }
}
