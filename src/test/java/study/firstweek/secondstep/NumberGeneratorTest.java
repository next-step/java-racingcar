package study.firstweek.secondstep;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberGeneratorTest {

    private final NumberGenerator generator = new NumberGenerator();

    @DisplayName("랜덤 숫자가 생성 된다")
    @Test
    void carTest() {
        assertThat(generator.getRandomNumber())
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(9);
    }

}