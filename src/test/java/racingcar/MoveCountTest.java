package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.MoveCount;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveCountTest {

    public static final int MOVE_COUNT = 1;
    public static final int MOVE_COUNT2 = 2;
    public static final int MAX_MOVE_COUNT = 2;

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

    @DisplayName("moveCount, maxMoveCount 비교 메서드 (>)")
    @Test
    void isGreaterThan() {
        //given
        MoveCount myMoveCount = new MoveCount(MOVE_COUNT);


        //when
        boolean isGreater = myMoveCount.isGreaterThan(MAX_MOVE_COUNT);

        //then
        assertThat(isGreater).isFalse();
    }

    @DisplayName("moveCount, maxMoveCount 비교 메서드 (=)")
    @Test
    void isGreaterThan() {
        //given
        MoveCount myMoveCount = new MoveCount(MOVE_COUNT2);


        //when
        boolean isEqual = myMoveCount.isEqualTo(MAX_MOVE_COUNT);

        //then
        assertThat(isEqual).isTrue();
    }
}
