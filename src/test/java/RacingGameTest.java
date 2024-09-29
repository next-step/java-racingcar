import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.RacingGame;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6, 11})
    @DisplayName("자동차 수에 맞게 RacingCar 객체가 생성된다.")
    void createRacingGame(int carCount) {
        RacingGame game = new RacingGame(carCount, 3, () -> true);

        assertEquals(carCount, game.getCarCount());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6, 11})
    @DisplayName("지정된 시도 횟수만큼 게임이 진행된다.")
    void gameRunsForSpecifiedAttempts(int attempts) {
        RacingGame game = new RacingGame(3, attempts, () -> true);

        List<List<Integer>> results = game.run();

        assertEquals(attempts, results.size());
    }

    @DisplayName("항상 전진하는 경우, 모든 차가 매 라운드마다 전진한다.")
    @Test
    void allCarsAdvanceWhenConditionAlwaysTrue() {
        RacingGame game = new RacingGame(3, 5, () -> true);

        List<List<Integer>> results = game.run();

        for (int i = 0; i < results.size(); i++) {
            List<Integer> roundResult = results.get(i);
            assertEquals(3, roundResult.size());
            for (int position : roundResult) {
                assertEquals(i + 1, position);
            }
        }
    }

    @Test
    @DisplayName("항상 정지하는 경우, 모든 차가 움직이지 않는다.")
    void noCarsAdvanceWhenConditionAlwaysFalse() {
        RacingGame game = new RacingGame(3, 5, () -> false);
        List<List<Integer>> results = game.run();

        for (List<Integer> roundResult : results) {
            assertEquals(3, roundResult.size());
            for (int position : roundResult) {
                assertEquals(0, position);
            }
        }
    }

}