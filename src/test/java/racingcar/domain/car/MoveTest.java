package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.random.MoveGen;
import racingcar.domain.random.NoMoveGen;

class MoveTest {
    @DisplayName("전진 조건을 만족한다면 true를 반환한다.")
    @Test
    void trueIfStatisfiedMoveCondition() {
        //given
        Move move = Move.get();

        //when
        boolean goAheadIfMoveCondition = move.isSatisfiedMoveCondition(new MoveGen());

        //then
        assertThat(goAheadIfMoveCondition).isTrue();
    }

    @DisplayName("전진 조건을 만족한다면 false를 반환한다.")
    @Test
    void falseIfStatisfiedMoveCondition() {
        //given
        Move move = Move.get();

        //when
        boolean goAheadIfMoveCondition = move.isSatisfiedMoveCondition(new NoMoveGen());

        //then
        assertThat(goAheadIfMoveCondition).isFalse();
    }
}