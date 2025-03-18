package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.entity.RacingGame;
import racing.rule.RandomMoveRule;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {RandomMoveRule.MIN_MOVE_VALUE, RandomMoveRule.MIN_MOVE_VALUE + 2})
    @DisplayName("value가 MIN_MOVE_VALUE 이상이면 전진 가능하다.")
    public void car_moves_whenValueIs_MinMoveValueOrMore(int input) {
        RandomMoveRule randomMoveRule = new RandomMoveRule();

        boolean actual = randomMoveRule.isMovable(input);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {RandomMoveRule.MIN_MOVE_VALUE - 1, RandomMoveRule.MIN_MOVE_VALUE - 2})
    @DisplayName("value가 MIN_MOVE_VALUE 미만이면 움직이지 않는다.")
    public void car_stays_whenValueIs_LessThanMinMoveValue(int input) {
        RandomMoveRule randomMoveRule = new RandomMoveRule();

        boolean actual = randomMoveRule.isMovable(input);
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("가장 멀리간 자동차로 우승자를 선정한다. (동반 우승 가능) ")
    public void select_winners_basedOn_MaxPosition() {
        // given
        // when
        // then
    }

}