package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.config.RacingCarException.PLAYING_COUNT_OUT_OF_RANGE;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundsTest {

    @Test
    @DisplayName("레이싱 시도 횟수를 넣으면 라운드 목록을 반환한다.")
    void from_PositivePlayingCount_Rounds() {
        final int playingCount = 5;
        final Rounds rounds = Rounds.from(playingCount);

        assertThat(rounds.rounds())
                .hasSize(playingCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("0 이하의 레이싱 시도 횟수만큼 라운드를 생성하는 경우 예외를 던진다.")
    void from_NegativeOrZeroPlayingCount_Exception(final int negativeOrZeroPlayingCount) {
        assertThatThrownBy(() -> Rounds.from(negativeOrZeroPlayingCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PLAYING_COUNT_OUT_OF_RANGE.message(negativeOrZeroPlayingCount));
    }
}
