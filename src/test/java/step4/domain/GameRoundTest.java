package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.RacingGameException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameRoundTest {

    GameRound gameRound = new GameRound();

    @Test
    @DisplayName("getRoundResult()실행 시, 게임 결과가 없는 경우 예외를 발생시킨다.")
    void getRoundResultException() {
        assertThatExceptionOfType(RacingGameException.class)
                .isThrownBy(() -> gameRound.getGameRoundResult());
    }

}