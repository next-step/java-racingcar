package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoveCountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 차량_움직이는_횟수가_0_이하일_경우_에러_발생(int moveCount) {
        assertThatThrownBy(() -> new MoveCount(moveCount)).isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7})
    void MoveCount가_0이_되엇을때_isDone_true(int count) {
        MoveCount moveCount = new MoveCount(count);

        for (int i = 0; i < count; i++) {
            moveCount.decreaseMoveCount();
        }

        assertThat(moveCount.isDone()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7})
    void MoveCount가_0이_아닐때는_isDone_false(int count) {
        MoveCount moveCount = new MoveCount(count);

        moveCount.decreaseMoveCount();

        assertThat(moveCount.isDone()).isFalse();
    }

    @Test
    void MoveCount가_0_이하일때_에러_발생() {
        assertThatThrownBy(() -> new MoveCount(0).decreaseMoveCount()).isInstanceOf(IllegalStateException.class);
    }

}
