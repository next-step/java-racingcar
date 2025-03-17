package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingUtilTest {
    @Test
    void generate_random_num_0_9() {
        int randomNum = RacingUtil.generateRandomNum();
        for (int i = 0; i < 100; i++) {
            assertThat(randomNum).isBetween(0, 9);
        }
    }
}
