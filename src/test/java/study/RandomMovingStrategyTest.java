package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMovingStrategyTest {

    @DisplayName("랜덤 숫자가 0~9사이에서 리턴되는지 테스트")
    @Test
    public void getRandomNumberTest() {

        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
        int randomNumber = randomMovingStrategy.getRandomNumber();
        assertThat(randomNumber).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}
