package racing.v1.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {
    @Test
    @DisplayName("랜덤 숫자는 0~9까지 이다.")
    void step1() {
        assertThat(new RandomGenerator().generate(10))
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
