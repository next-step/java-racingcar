package carracing.domain.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StopStrategyTest {

    @DisplayName("정지 전략은 움직일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 100})
    void isMovable(int number) {
        MoveStrategy moveStrategy = new StopStrategy();

        assertThat(moveStrategy.isMovable()).isFalse();
    }

}