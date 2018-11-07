package racingcar;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class RandomUtilsTest {

    @Test
    public void 랜덤숫자를_생성할수있다() {
        assertThat(RandomUtils.generateRandomInt()).isNotNull();
        assertThat(RandomUtils.generateRandomInt()).isPositive();

    }
}