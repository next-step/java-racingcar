package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 숫자 생성기 테스트")
public class RandomGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자는 0-9사이에서 생성된다.")
    void generatorNumberTest() {
        RandomGenerator randomGenerator = new RandomGenerator();
        assertThat(randomGenerator.generateNumber()).isBetween(0,9);
    }
}
