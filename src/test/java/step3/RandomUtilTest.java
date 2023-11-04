package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomUtilTest {

    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    @Test
    public void 랜덤값_0부터_9사이() {
        int random = RandomUtil.random();
        assertThat(random).isBetween(RANDOM_MIN, RANDOM_MAX);
    }

}
