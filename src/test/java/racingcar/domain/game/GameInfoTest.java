package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameInfoTest {

    @Nested
    @DisplayName("GameInfo의 생성 성공 테스트를 진행한다.")
    class SuccessCondition{

        @Test
        @DisplayName("사용자가 입력한 게임횟수만큼 게임이 진행되면 게임은 종료된다.")
        void createGameInfo() {
            int carCount = 1;
            int totalGameCount = 1;

            GameInfo gameInfo = new GameInfo(carCount, totalGameCount);
            gameInfo.increaseGameRound();

            assertThat(gameInfo.isEndGame()).isTrue();
        }
    }

    @Nested
    @DisplayName("GameInfo의 생성 실패 테스트를 진행한다.")
    class FailCondition{

        @ParameterizedTest
        @ValueSource(ints = {0, -1, -3})
        @DisplayName("사용자가 자동차 갯수를 0 혹은 음수로 만들경우 오류가 발생한다.")
        void createGameInfo_자동차_0개(int carCount) {
            int gameCount = 1;

            assertThatThrownBy(() -> new GameInfo(carCount, gameCount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("최소 1개 이상의 자동차를 만들어야합니다.");
        }

        @ParameterizedTest
        @ValueSource(ints = {0, -1, -3})
        @DisplayName("사용자가 게임횟수를 0 혹은 음수로 만들경우 오류가 발생한다.")
        void createGameInfo_게임횟수_0번(int gameCount) {
            int carCount = 1;

            assertThatThrownBy(() -> new GameInfo(carCount, gameCount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("최소 1번 이상의 게임을 진행해야 합니다.");
        }
    }
}