package study.step4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.model.strategy.MoveStrategy;

public class RandomMoveStrategyTest {

    @Test
    @DisplayName("Car Randome Move Stategy Fail Test")
    void carMoveStrategyFailTest() {
        MoveStrategy moveStrategy = () -> false;
        assertThat(moveStrategy.isMoveCondition()).isFalse();
    }

    @Test
    @DisplayName("Car Randome Move Stategy Success Test")
    void carMoveStrategySuccessTest() {
        MoveStrategy moveStrategy = () -> true;
        assertThat(moveStrategy.isMoveCondition()).isTrue();
    }
}