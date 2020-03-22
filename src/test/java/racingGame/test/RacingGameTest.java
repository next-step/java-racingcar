package racingGame.test;

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
    @DisplayName("참가자 설정 & 게임 수 설정 시 음수 값에 대한 Exception 테스트")
    void setGameCount() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    racingGame.participate(-3, 5);
                });

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    racingGame.participate(4,-5);
                });
    }
}