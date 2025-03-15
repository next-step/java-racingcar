package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    @DisplayName("Random value가 0~9 사이의 값으로 생성된다.")
    public void randomValue_is_valid_whenBetweenZeroAndNine() {
        int actual = RacingGame.getRandomValue();
        assertThat(actual).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {RacingGame.MIN_MOVE_VALUE, RacingGame.MIN_MOVE_VALUE + 2})
    @DisplayName("Random value가 MIN_MOVE_VALUE 이상이면 전진 가능하다.")
    public void car_moves_whenValueIsOrMore(int input) {
        boolean actual = RacingGame.isMovable(input);
        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {RacingGame.MIN_MOVE_VALUE - 1, RacingGame.MIN_MOVE_VALUE - 2})
    @DisplayName("Random value가 MIN_MOVE_VALUE 미만이면 움직이지 않는다.")
    public void car_stays_whenValueIsLessThan_MinMoveValue(int input) {
        boolean actual = RacingGame.isMovable(input);
        assertThat(actual).isFalse();
    }

}