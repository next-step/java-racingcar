package racingcar.mocks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.util.DrivingStrategy;
import racingcar.util.RandomStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomStrategyTest {

    @Test
    @DisplayName("Singleton으로 동작하는지")
    void getInstance() {
        DrivingStrategy strategy1 = RandomStrategy.getInstance();
        DrivingStrategy strategy2 = RandomStrategy.getInstance();

        assertThat(strategy1).isSameAs(strategy2);
    }

    @RepeatedTest(20)
    @DisplayName("throwDice는 0~10 사이의 수를 리턴")
    void throwDice() {
        DrivingStrategy strategy = RandomStrategy.getInstance();
        assertThat(strategy.throwDice()).isBetween(0, 10);

    }
}
