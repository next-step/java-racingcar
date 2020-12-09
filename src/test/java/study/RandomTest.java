package study;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {

    @RepeatedTest(20)
    void randomRangeTest() {
        Random random = new Random();
        int result = random.nextInt(9);

        assertThat(result).isBetween(0, 9);
    }
}
