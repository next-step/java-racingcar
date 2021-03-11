package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomUtilTest {

    @Test
    public void makeRandomNumber_ShouldReturnBetweenZeroToNine() {
        assertThat(RandomUtil.makeRandomNumber()).isBetween(0, 9);
    }
}
