package study.racinggame.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoveStrategyTest {
    @Test
    @DisplayName("파라미터의 숫자가 전진 조건 이상인 경우 앞으로 이동")
    void 파라미터의_숫자가_전진_조건_이상인_경우_앞으로_이동() {
        MoveStrategy moveStrategy = new RaceGameMoveStrategy();
        boolean actual =  moveStrategy.canMove(5);
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("파라미터의 숫자가 전진 조건 미만인 경우 이동하지 않음")
    void 파라미터의_숫자가_전진_조건_미만인_경우_이동하지_않음() {
        MoveStrategy moveStrategy = new RaceGameMoveStrategy();
        boolean actual =  moveStrategy.canMove(3);
        assertThat(actual).isFalse();
    }
}