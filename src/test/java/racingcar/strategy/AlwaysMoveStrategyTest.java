package racingcar.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AlwaysMoveStrategyTest {

    @Test
    @DisplayName("숫자에 상관 없이 항상 전진할 수 있다.")
    void alwaysMovable() {
        MoveStrategy moveStrategy = new AlwaysMoveStrategy();
        assertThat(moveStrategy.isMovable()).isTrue();
    }

}