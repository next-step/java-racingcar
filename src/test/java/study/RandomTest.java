package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomTest {
    @DisplayName("[study]Random의 nextInt 메서드에 인자를 전달하면 0부터 인자 사이의 값만 랜덤하게 결정된다.")
    @Test
    void return_positive_number_below_argument() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int result = random.nextInt(10);

            assertThat(result).isBetween(0, 9);
        }
    }
}
