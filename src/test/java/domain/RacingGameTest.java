package domain;

import movingStrategy.AlwaysMove;
import movingStrategy.Moveable;
import movingStrategy.RandomlyMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    private final Moveable alwaysMove = new AlwaysMove();
    private static final int NUMBER_OF_TRIAL = 5;
    private static final int NUMBER_OF_CAR = 3;

    @DisplayName("자동차의 수 또는 시도 횟수가 0보다 작은 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 0", "0, 0", "-1, 1", "1, -1", "-1, -1"})
    void test(Integer numberOfCar, Integer numberOfRacing) {
        // When & Then
        assertThatThrownBy(() -> new RacingGame(numberOfCar, numberOfRacing, alwaysMove))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 수 또는 시도 횟수가 0보다 큰 경우 예외 발생하지 않음")
    @Test
    void gameStartTest() {
        // Given
        int validNumberOfTrial = 5;
        int validNumberOfCar = 3;

        // When
        RacingGame racingGame = new RacingGame(validNumberOfCar, validNumberOfTrial, alwaysMove);

        // Then
        assertThatNoException().isThrownBy(racingGame::gameStart);
    }

    @DisplayName("numberOfCar 만큼 자동차가 생성됨")
    @Test
    void carProduceTest() {
        RacingGameResult racingGameResult = playTestGame(alwaysMove);
        List<RoundResult> roundResults = racingGameResult.getAllRoundResults();
        assertThat(roundResults.get(0).whereAreCars()).hasSize(NUMBER_OF_CAR);
    }

    @DisplayName("numberOfTrial 만큼 자동차가 진행함")
    @Test
    void alwaysMoveTest() {
        RacingGameResult racingGameResult = playTestGame(alwaysMove);
        assertThat(racingGameResult.getLastRoundResult().whereAreCars()).containsOnly(NUMBER_OF_TRIAL);
    }

    @DisplayName("numberOfTrial 보다 작거나 같은 값만큼 자동차가 진행함")
    @Test
    void randomlyMoveTest() {
        RandomlyMove randomlyMove = new RandomlyMove(10, 4);
        RacingGameResult racingGameResult = playTestGame(randomlyMove);

        assertThat(racingGameResult.getLastRoundResult().whereAreCars())
                .allMatch(progress -> progress <= NUMBER_OF_TRIAL);
    }

    private RacingGameResult playTestGame(Moveable moveable) {
        RacingGame racingGame = new RacingGame(RacingGameTest.NUMBER_OF_CAR, RacingGameTest.NUMBER_OF_TRIAL, moveable);
        return racingGame.gameStart();
    }
}