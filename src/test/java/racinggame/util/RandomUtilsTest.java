package racinggame.util;

import org.junit.Test;
import racinggame.util.RandomUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilsTest {

    @Test
    public void 랜덤_테스트() {
        for(int i =0 ; i < 100; i++) {
            int randomNumber = RandomUtils.getRandom10();

            assertThat(randomNumber).isGreaterThanOrEqualTo(0);
            assertThat(randomNumber).isLessThanOrEqualTo(9);
        }
    }
}