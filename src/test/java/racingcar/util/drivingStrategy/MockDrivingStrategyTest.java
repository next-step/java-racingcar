package racingcar.util.drivingStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MockDrivingStrategyTest {

    @Test
    @DisplayName("Singleton으로 동작하는지")
    void getInstance() {
        DrivingStrategy strategy1 = MockDrivingStrategy.getInstance();
        DrivingStrategy strategy2 = MockDrivingStrategy.getInstance();

        assertThat(strategy1).isSameAs(strategy2);
    }

    @Test
    @DisplayName("throwDice는 무조건 10 return")
    void throwDice() {
        DrivingStrategy strategy = MockDrivingStrategy.getInstance();
        assertThat(strategy.throwDice()).isEqualTo(10);
        assertThat(strategy.throwDice()).isEqualTo(10);
        assertThat(strategy.throwDice()).isEqualTo(10);
        assertThat(strategy.throwDice()).isEqualTo(10);
    }
}
