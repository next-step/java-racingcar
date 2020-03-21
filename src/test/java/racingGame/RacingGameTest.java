package racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class RacingGameTest {

    private RacingGame racingGame;
    private RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
        randomNumber = new RandomNumber();
    }

    @Test
    @DisplayName("참가자 설정 시 음수 값에 대한 Exception 테스트")
    void setParticipateCount() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    racingGame.setParticipateCount(-4);
                });
    }

    @Test
    @DisplayName("게임 수 설정 시 음수 값에 대한 Exception 테스트")
    void setGameCount() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    racingGame.setGameCount(-6);
                });
    }

    @Test
    void start() {
        racingGame.setParticipateCount(3);
        racingGame.setGameCount(5);
        System.out.print(racingGame.start(randomNumber));
    }
}