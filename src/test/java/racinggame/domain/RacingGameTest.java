package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    private final RacingGame racingGame = new RacingGame();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("게임을 시도할 회수만큼 게임 라운드가 증가한다.")
    void getGameRound(int tryCount) {
        int carCount = 3;
        GameRounds gameResult = racingGame.start(carCount, tryCount);
        assertThat(gameResult.getRoundCount()).isEqualTo(tryCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:-1", "3:-1", "-3:-3"}, delimiter = ':')
    @DisplayName("게임의 자동차 대수 또는 시도할 횟수에 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.")
    void throwExceptionWhenNegativeParameter(int carCount, int tryCount) {
        assertThatThrownBy(() -> racingGame.start(carCount, tryCount))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수가 전달되어 게임을 시작할 수 없습니다.");
    }

}
