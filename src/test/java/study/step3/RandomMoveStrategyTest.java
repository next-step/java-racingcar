package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step3.model.strategy.MoveStrategy;
import study.step3.model.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMoveStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Car Randome Move Stategy Fail Test")
    void carMoveStrategyFailTest(int inputCarDistance) {
        MoveStrategy moveStrategy = new RandomMoveStrategy(inputCarDistance);
        assertThat(moveStrategy.isMoveCondition()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    @DisplayName("Car Randome Move Stategy Success Test")
    void carMoveStrategySuccessTest(int inputCarDistance) {
        MoveStrategy moveStrategy = new RandomMoveStrategy(inputCarDistance);
        assertThat(moveStrategy.isMoveCondition()).isTrue();
    }

}
