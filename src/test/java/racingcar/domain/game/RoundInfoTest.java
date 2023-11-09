package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RoundInfoTest {

    @Test
    @DisplayName("게임라운드를 totalGameRound 만큼 진행할 경우 게임은 끝난다.")
    void endGameTest_end() {
        int totalGameRound = 5;
        RoundInfo roundInfo = new RoundInfo(totalGameRound);

        for (int i = 0; i < totalGameRound; i++) {
            roundInfo.increaseRound();
        }

        assertThat(roundInfo.isEndGame()).isTrue();
    }

    @Test
    @DisplayName("게임라운드를 totalGameRound 만큼 진행하지 않았으면 게임은 끝나지 않는다.")
    void endGameTest_notEnd() {
        int totalGameRound = 5;
        RoundInfo roundInfo = new RoundInfo(totalGameRound);

        for (int i = 0; i < totalGameRound -1; i++) {
            roundInfo.increaseRound();
        }

        assertThat(roundInfo.isEndGame()).isFalse();
    }

    @Test
    @DisplayName("1개 미만의 숫자를 입력했을 경우 오류가 발생한다.")
    void createRoundInfo_1개미만() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RoundInfo(0))
                .withMessage("최소 1번 이상의 게임을 진행해야 합니다.");
    }
}