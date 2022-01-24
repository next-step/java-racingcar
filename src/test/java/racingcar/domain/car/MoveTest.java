package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.random.MoveGen;
import racingcar.domain.random.NoMoveGen;

class MoveTest {
    @DisplayName("전진 조건을 만족한다면 true를 반환한다.")
    @Test
    void trueIfStatisfiedMoveCondition() {
        //given
        Move move = new Move();

        //when
        boolean goAheadIfMoveCondition = move.isSatisfiedMoveCondition(new MoveGen());

        //then
        Assertions.assertThat(goAheadIfMoveCondition).isTrue();
    }

    @DisplayName("전진 조건을 만족한다면 false를 반환한다.")
    @Test
    void falseIfStatisfiedMoveCondition() {
        //given
        Move move = new Move();

        //when
        boolean goAheadIfMoveCondition = move.isSatisfiedMoveCondition(new NoMoveGen());

        //then
        Assertions.assertThat(goAheadIfMoveCondition).isFalse();
    }
}