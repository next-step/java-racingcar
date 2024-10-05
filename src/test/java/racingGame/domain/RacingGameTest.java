package racingGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

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

        GameResult results = game.run();

        assertEquals(attempts, results.getRoundResults().size());
    }

    @DisplayName("항상 전진하는 경우, 모든 차가 매 라운드마다 전진한다.")
    @Test
    void allCarsAdvanceWhenConditionAlwaysTrue() {
        RacingGame game = new RacingGame(CAR_NAMES, 5, () -> true);

        GameResult results = game.run();

        List<RoundResult> roundResults = results.getRoundResults();
        for (int i = 0; i < roundResults.size(); i++) {
            RoundResult roundResult = roundResults.get(i);
            assertEquals(CAR_NAMES.length, roundResult.getRacingCars().size());
            for (var car : roundResult.getRacingCars()) {
                assertEquals(i + 1, car.getPositionValue());
            }
        }
    }


    @DisplayName("항상 정지하는 경우, 모든 차가 움직이지 않는다.")
    @Test
    void noCarsAdvanceWhenConditionAlwaysFalse() {
        RacingGame game = new RacingGame(CAR_NAMES, 5, () -> false);
        GameResult results = game.run();

        for (RoundResult roundResult : results.getRoundResults()) {
            assertEquals(CAR_NAMES.length, roundResult.getRacingCars().size());
            for (var car : roundResult.getRacingCars()) {
                assertEquals(0, car.getPositionValue());
            }
        }
    }

    @DisplayName("모든 차가 같은 거리를 이동했을 때 모두가 우승자가 된다.")
    @Test
    void allCarsWinWhenSameDistance() {
        RacingGame game = new RacingGame(CAR_NAMES, 5, () -> true);

        GameResult results = game.run();
        List<String> actual = results.getWinners();

        assertIterableEquals(
                actual.stream().sorted().collect(Collectors.toList()),
                Arrays.stream(CAR_NAMES).sorted().collect(Collectors.toList())
        );
    }

    @DisplayName("차가 모두 움직이지 않았을 때 모두가 우승자가 된다.")
    @Test
    void allCarsWinWhenConditionAlwaysFalse() {
        RacingGame game = new RacingGame(CAR_NAMES, 5, () -> false);

        GameResult results = game.run();
        List<String> actual = results.getWinners();

        assertIterableEquals(
                actual.stream().sorted().collect(Collectors.toList()),
                Arrays.stream(CAR_NAMES).sorted().collect(Collectors.toList())
        );
    }

    @DisplayName("한 대의 차만 가장 멀리 갔을 때 한 명만 우승자가 된다.")
    @Test
    void singleCarWinWhenOneMoveFurthest() {
        MovementCondition moveOnlyFirst = new MovementCondition() {
            private int count = 0;

            @Override
            public boolean canMove() {
                return count++ == 0;
            }
        };
        RacingGame game = new RacingGame(CAR_NAMES, 5, moveOnlyFirst);

        GameResult results = game.run();
        List<String> actual = results.getWinners();

        assertEquals(1, actual.size());
        assertEquals(CAR_NAMES[0], actual.get(0));

    }

}