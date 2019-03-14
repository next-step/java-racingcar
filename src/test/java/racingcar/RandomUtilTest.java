package racingcar;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomUtilTest {

    @Test
    public void 영부터_구까지_랜덤값() {
        int number = new RandomUtil(0,9).randomInt();

        for(int i = 0; i < 100; i++) {
            assertThat(number).isBetween(0,9);
        }
    }
}