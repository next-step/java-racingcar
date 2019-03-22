package racingcar;

import org.junit.Test;
import racingcar.domain.RandomUtil;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomUtilTest {

    @Test
    public void 영부터_구까지_랜덤값() {
        for(int i = 0; i < 100; i++) {
            assertThat(new RandomUtil(0,9).randomInt()).isBetween(0,9);
        }
    }
}