package study;

import org.junit.jupiter.api.Test;
import racing.RacingRule;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    @Test
    void 랜덤값이0이상9이하() {
        Random random = new Random();
        int randomNumber = 0;
        for (int i = 0; i < 100; i++) {
            randomNumber = random.nextInt(10);
            assertThat(randomNumber).isBetween(0,9);
        }
    }
}
