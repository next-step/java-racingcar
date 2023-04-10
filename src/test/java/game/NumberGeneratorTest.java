package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    @DisplayName("RandomNumberGenerator 사용시 0~10 사이의 수만 생성됩니다.")
    void test01() {
        NumberGenerator generator = new RandomNumberGenerator();
        int[] results = new int[100];
        for (int i = 0; i < 100; i++) {
            results[i] = generator.generate();
        }

        for (int num : results) {
            assertThat(isValidRange(num)).isTrue();
        }
    }

    private boolean isValidRange(int num) {
        return 0 <= num && num <= 10;
    }
}