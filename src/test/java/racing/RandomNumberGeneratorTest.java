package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("랜덤숫자는_0_9_사이의_값이다_1,000번_확인")
    void generate() throws Exception {
        for(int i = 0; i < 1_000; i++) {
            assertThat(isNumberLessThanTen(RandomNumberGenerator.generate())).isTrue();
        }
    }

    private boolean isNumberLessThanTen(int number) {
        return ((number >= 0) && (number < 10));
    }
}
