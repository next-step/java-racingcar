package edu.nextstep.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @DisplayName("레이싱 게임 전체 테스트")
    @ParameterizedTest
    @CsvSource(value = { "3:5", "5:6", "7:4" }, delimiter = ':')
    void exceptionTest(String carNum, String gameNum) {
        racingGame.carNum = Integer.valueOf(carNum);
        racingGame.gameNum = Integer.valueOf(gameNum);

        racingGame.startGame();
        racingGame.resultGame();
    }
}
