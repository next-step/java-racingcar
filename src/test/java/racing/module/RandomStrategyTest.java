package racing.module;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStrategyTest {
    @Test
    @DisplayName("랜덤생성 숫자가 0~9인지 확인")
    void carGame() {
        RandomStrategy strategy = new RandomStrategy();
        for (int i = 0; i < 1000; i++) {
            assertThat(strategy.getRandomNumber()).isBetween(0, 9);
        }
    }
}
