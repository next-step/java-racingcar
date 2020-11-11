package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.GameRound;
import step4.exception.GameEndException;
import step4.exception.MinimumTryCountException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameRoundTest {


    @Test
    @DisplayName("자동차 경주횟수가 1미만 일때익셉션 확인")
    void throwExceptionMinTryCount() {
        //then
        assertThatThrownBy(() -> GameRound.of(0)).isInstanceOf(MinimumTryCountException.class);

    }

    @Test
    @DisplayName("자동차 게임 원하는 횟수보다 많이 시도했을 경우 익셉션 발생")
    void throwExceptionGameEndException() {
        int tryCount = 3;
        GameRound gameRound = GameRound.of(tryCount);
        for (int i = 0; i < tryCount; i++) {
            gameRound.stackGameRound();
        }
        assertThatThrownBy(() -> gameRound.stackGameRound()).isInstanceOf(GameEndException.class);

    }
}