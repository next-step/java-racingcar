package study.step_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("0과 9 사이의 랜덤 값을 구한다")
    void shouldReturnRandomNumber() {
        Random random = new Random();
        int result = random.nextInt(10);

        assertThat(result).isLessThan(10);
    }
}
