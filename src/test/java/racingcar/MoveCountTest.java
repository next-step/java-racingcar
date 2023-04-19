package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveCountTest {

    public static final int MOVE_COUNT = 1;

    @DisplayName("문자열 포장 객체 MoveCount 생성 확인")
    @Test
    void constructMoveCount() {
        //given
        MoveCount myMoveCount = new MoveCount(MOVE_COUNT);

        //when
        int moveCount = myMoveCount.getMoveCount();

        //then
        assertThat(moveCount).isEqualTo(MOVE_COUNT);
    }
}
