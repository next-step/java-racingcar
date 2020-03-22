package racingGame.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.game.CarForwardRule;
import racingGame.game.RacingGame;
import racingGame.game.RacingGameRule;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        RacingGameRule gameRule = new CarForwardRule();
        racingGame = new RacingGame(gameRule);
    }

    @Test
    @DisplayName("참가자 설정 & 게임 수 설정 시 값에 대한 Exception 테스트")
    void participate() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    racingGame.participate(null, 5);
                });
    }
}