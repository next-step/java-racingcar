package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomMovingStrategyTest {

    @DisplayName("0 이상 10 미만 임의의 수를 생성한다.")
    @Test
    public void shouldReturnRandomNumber() {
        //given
        int randomNum = RandomMovingStrategy.getRandomNumber();

        assertThat(randomNum).isGreaterThanOrEqualTo(0);
        assertThat(randomNum).isLessThan(10);
    }

}