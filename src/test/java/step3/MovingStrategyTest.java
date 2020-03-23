package step3;

import CarRacing.MovingStrategy;
import CarRacing.RacingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingStrategyTest {
    @DisplayName("레이싱 스트레티지에 무빙 스트레티지가 잘 들어가는 것을 확인")
    @Test
    void movingStrategyMovableTest() {
        RacingStrategy racingStrategy = new MovingStrategy();
        assertThat(racingStrategy.movable()).isIn(true, false);
    }
}
