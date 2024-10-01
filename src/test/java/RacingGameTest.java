import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.RacingGame;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    private static final String[] CAR_NAMES = {"car1", "car2", "car3", "car4", "car5"};

    @ParameterizedTest
    @MethodSource("provideCarNames")
    @DisplayName("입력된 자동차 이름 수에 맞게 RacingCar 객체가 생성된다.")
    void createRacingGame(String[] carNames, int expectedCount) {
        RacingGame game = new RacingGame(carNames, 3, () -> true);

        assertEquals(expectedCount, game.getCarCount());
    }

    private static Stream<Arguments> provideCarNames() {
        return Stream.of(
                Arguments.of(new String[]{"car1"}, 1),
                Arguments.of(new String[]{"car1", "car2", "car3"}, 3),
                Arguments.of(new String[]{"a", "b", "c", "d", "e"}, 5)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6, 11})
    @DisplayName("지정된 시도 횟수만큼 게임이 진행된다.")
    void gameRunsForSpecifiedAttempts(int attempts) {
        RacingGame game = new RacingGame(CAR_NAMES, attempts, () -> true);

        List<List<Integer>> results = game.run();

        assertEquals(attempts, results.size());
    }

    @DisplayName("항상 전진하는 경우, 모든 차가 매 라운드마다 전진한다.")
    @Test
    void allCarsAdvanceWhenConditionAlwaysTrue() {
        RacingGame game = new RacingGame(CAR_NAMES, 5, () -> true);

        List<List<Integer>> results = game.run();

        for (int i = 0; i < results.size(); i++) {
            List<Integer> roundResult = results.get(i);
            assertEquals(CAR_NAMES.length, roundResult.size());
            for (int position : roundResult) {
                assertEquals(i + 1, position);
            }
        }
    }

    @Test
    @DisplayName("항상 정지하는 경우, 모든 차가 움직이지 않는다.")
    void noCarsAdvanceWhenConditionAlwaysFalse() {
        RacingGame game = new RacingGame(CAR_NAMES, 5, () -> false);
        List<List<Integer>> results = game.run();

        for (List<Integer> roundResult : results) {
            assertEquals(CAR_NAMES.length, roundResult.size());
            for (int position : roundResult) {
                assertEquals(0, position);
            }
        }
    }

}