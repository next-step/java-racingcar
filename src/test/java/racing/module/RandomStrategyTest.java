package racing.module;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStrategyTest {
    @Test
    @RepeatedTest(1000)
    @DisplayName("랜덤생성 숫자가 0~9인지 확인")
    void carGame() {
        RandomStrategy strategy = new RandomStrategy();
        assertThat(strategy.getRandomNumber()).isBetween(0, 9);
    }
}
