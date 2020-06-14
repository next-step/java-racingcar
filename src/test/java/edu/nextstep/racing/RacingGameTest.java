package edu.nextstep.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameTest {
    private RacingGame racingGame;
    private RacingCarMovingCheck racingCarMovingCheck;
    private RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber();
        racingCarMovingCheck = new RacingCarMovingCheck(randomNumber);
        this.racingGame = new RacingGame();
    }

    @DisplayName("레이싱 게임 전체 테스트")
    @ParameterizedTest
    @CsvSource(value = { "pobi,crong,honux:5" }, delimiter = ':')
    void gameTest(String carNames, String gameNum) {
        racingGame.setUpTest(racingCarMovingCheck, carNames, Integer.valueOf(gameNum));
    }

    @DisplayName("잘못된 데이터 입력")
    @ParameterizedTest
    @CsvSource(value = { "pobitest:1", "racingcar:-2", "nextstep:0" }, delimiter = ':')
    void inputDataTest(String carNames, String gameNum) {
        assertThatIllegalArgumentException().isThrownBy( () -> racingGame.setUpTest(
                racingCarMovingCheck, carNames, Integer.valueOf(gameNum)));
    }

}
