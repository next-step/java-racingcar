package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    private final RacingGame racingGame = new RacingGame();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("게임을 시도할 회수만큼 게임 라운드가 증가한다.")
    void getGameRound(int tryCount) {
        GameRounds gameResult = racingGame.start(initCarNames(), tryCount);
        assertThat(gameResult.getRoundCount()).isEqualTo(tryCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    @DisplayName("시도할 횟수에 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.")
    void throwExceptionWhenNegativeParameter(int tryCount) {
        assertThatThrownBy(() -> racingGame.start(initCarNames(), tryCount))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수가 전달되어 게임을 시작할 수 없습니다.");
    }

    private List<String> initCarNames() {
        return List.of("테스트카1", "테스트카2");
    }

}
