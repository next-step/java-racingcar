package race.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {
    @Test
    void 랜덤_값() {
        assertThat(new RandomUtil().randomNum()).isBetween(0,9);
    }
}
