package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.RacingGameException;
import racinggame.game.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racinggame.exception.ErrorMessage.CAR_COUNT_REQUIREMENT_ERROR;
import static racinggame.exception.ErrorMessage.RACING_CAR_NAME_NOT_NULL;
import static racinggame.exception.ErrorMessage.ROUND_REQUIREMENT_ERROR;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong", "pobi,crong,honux"})
    @DisplayName("[성공] 2대 이상의 자동차 경주 게임을 생성할 수 있다.")
    void 생성테스트_01(final String carName) {
        assertDoesNotThrow(() -> RacingGame.of(carName, 3));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("[실패] 자동차 경주에 참여할 이름을 작성하지 않으면 게임을 생성할 수 없다.")
    void 생성테스트_02(final String carName) {
        assertThatThrownBy(() -> RacingGame.of(carName, 3))
                .isInstanceOf(RacingGameException.class)
                .hasMessageContaining(RACING_CAR_NAME_NOT_NULL.getMessage());
    }

    @Test
    @DisplayName("[실패] 1대의 자동차 경주 게임을 생성할 수 없다.")
    void 생성테스트_03() {
        assertThatThrownBy(() -> RacingGame.of("pobi", 3))
                .isInstanceOf(RacingGameException.class)
                .hasMessageContaining(CAR_COUNT_REQUIREMENT_ERROR.getMessage(2));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    @DisplayName("[성공] 1라운드 이상의 자동차 경주 게임을 생성할 수 있다.")
    void 생성테스트_04(final int roundCount) {
        assertDoesNotThrow(() -> RacingGame.of("pobi,crong,honux", roundCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("[성공] 1라운드 미만의 자동차 경주 게임을 생성할 수 있다.")
    void 생성테스트_05(final int roundCount) {
        assertThatThrownBy(() -> RacingGame.of("pobi,crong,honux", roundCount))
                .isInstanceOf(RacingGameException.class)
                .hasMessageContaining(ROUND_REQUIREMENT_ERROR.getMessage(1));
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong:1", "pobi,crong,honux:5"}, delimiter = ':')
    @DisplayName("[성공] 참가한 자동차들 모두 입력한 라운드 수만큼 시도해야 한다.")
    void start_01(final String carName, final int rounds) {
        // given
        final var game = RacingGame.of(carName, rounds);

        // when
        final var result = game.start();

        // then
        assertThat(result).hasSize(rounds);
    }

}
