package racinggame;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.RacingGameException;
import racinggame.game.RacingGame;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static racinggame.exception.ErrorMessage.CAR_COUNT_REQUIREMENT_ERROR;
import static racinggame.exception.ErrorMessage.ROUNDS_REQUIREMENT_ERROR;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 10})
    @DisplayName("[성공] 2대 이상의 자동차 경주 게임을 생성할 수 있다.")
    void 생성테스트_01(final int carCount) {
        assertDoesNotThrow(() -> new RacingGame(carCount, () -> true));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1})
    @DisplayName("[실패] 2대 미만의 자동차 경주 게임을 생성할 수 없다.")
    void 생성테스트_02(final int carCount) {
        assertThatThrownBy(() -> new RacingGame(carCount, () -> true))
                .isInstanceOf(RacingGameException.class)
                .hasMessageContaining(CAR_COUNT_REQUIREMENT_ERROR.getMessage(2));
    }

    @ParameterizedTest
    @CsvSource(value = {"5:1:1", "3:5:5"}, delimiter = ':')
    @DisplayName("[성공] 참가한 자동차들 모두 입력한 라운드 수만큼 시도해야 한다.")
    void start_01(final int carCount, final int rounds, final int position) {
        // given
        final var game = new RacingGame(carCount, () -> true);

        // when
        game.start(rounds);

        // then
        final var cars = game.getCars();
        final var softly = new SoftAssertions();
        for (final var car : cars) {
            softly.assertThat(car.position()).isEqualTo(position);
        }
        softly.assertAll();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("[실패] 게임에서 진행할 라운드 수가 1회 미만일 경우 게임이 진행되지 않는다.")
    void start_02(final int rounds) {
        // given
        final var game = new RacingGame(5, () -> true);

        // when & then
        assertThatThrownBy(() -> game.start(rounds))
                .isInstanceOf(RacingGameException.class)
                .hasMessageContaining(ROUNDS_REQUIREMENT_ERROR.getMessage(1));
    }

}
