package utils.random;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.random.RandomGenerator;

public class RandomGeneratorTest {

    @Test
    @DisplayName("0 에서 9 사이의 랜덤 값을 추출한다.")
    void test1() {
        int random = RandomGenerator.extractRandomSingleDigit();
        Assertions.assertThat(random >= 0).isTrue();
        Assertions.assertThat(random <= 9).isTrue();
    }
}
