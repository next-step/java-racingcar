package edu.nextstep.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameTest {
    private RacingGame racingGame;
    private RacingCarMovingCheck racingCarMovingCheck;

    @BeforeEach
    void setUp() {
        RandomNumber randomNumber = new RandomNumber();
        this.racingCarMovingCheck = new RacingCarMovingCheck(randomNumber);
        this.racingGame = new RacingGame(racingCarMovingCheck);
    }

    @DisplayName("레이싱 게임 전체 테스트")
    @ParameterizedTest
    @CsvSource(value = { "3:5", "5:6", "7:4" }, delimiter = ':')
    void gameTest(String carNum, String gameNum) {
        racingGame.setUp(Integer.valueOf(carNum), Integer.valueOf(gameNum));

        racingGame.startGame();
        racingGame.resultGame();
    }

    @DisplayName("잘못된 데이터 입력")
    @ParameterizedTest
    @CsvSource(value = { "-1:-2", "-4:0" }, delimiter = ':')
    void inputDataTest(String carNum, String gameNum) {
        assertThatIllegalArgumentException().isThrownBy( () -> racingGame.setUp(Integer.valueOf(carNum), Integer.valueOf(gameNum)));
    }

}
