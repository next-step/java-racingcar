package domain;

import movingStrategy.AlwaysMove;
import movingStrategy.Moveable;
import movingStrategy.RandomlyMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class RacingGameTest {

    private final Moveable alwaysMove = new AlwaysMove();
    private static final int NUMBER_OF_TRIAL = 5;
    private static final String[] RACING_CAR_NAMES = new String[]{"more", "much", "less"};

    @DisplayName("자동차의 수 또는 시도 횟수가 0보다 큰 경우 예외 발생하지 않음")
    @Test
    void startTest() {
        // Given
        int validTryCount = 5;
        String[] validNamesOfCar = {"more", "much", "less"};

        // When
        RacingGame racingGame = RacingGame.of(validNamesOfCar, validTryCount, alwaysMove);

        // Then
        assertThatNoException().isThrownBy(racingGame::start);
    }

    @DisplayName("namesOfCar 의 크기만큼 자동차가 생성됨")
    @Test
    void carProduceTest() {
        RacingGameResult racingGameResult = playTestGame(alwaysMove);
        List<RoundResult> roundResults = racingGameResult.getAllRoundResults();
        assertThat(roundResults.get(0).getRaceProgress()).hasSize(RACING_CAR_NAMES.length);
    }

    @DisplayName("tryCount 만큼 자동차가 진행함")
    @Test
    void alwaysMoveTest() {
        RacingGameResult racingGameResult = playTestGame(alwaysMove);
        RoundResult lastRoundResult = racingGameResult.getLastRoundResult();
        List<RacingCarCurrentStatus> raceProgress = lastRoundResult.getRaceProgress();
        List<Integer> carPositions = raceProgress.stream()
                .map(status -> status.position().value())
                .collect(Collectors.toList());

        assertThat(carPositions).containsOnly(NUMBER_OF_TRIAL);
    }

    @DisplayName("tryCount 보다 작거나 같은 값만큼 자동차가 진행함")
    @Test
    void randomlyMoveTest() {
        RandomlyMove randomlyMove = new RandomlyMove(10, 4);
        RacingGameResult racingGameResult = playTestGame(randomlyMove);

        RoundResult lastRoundResult = racingGameResult.getLastRoundResult();
        List<RacingCarCurrentStatus> raceProgress = lastRoundResult.getRaceProgress();
        List<Position> carPositions = raceProgress.stream()
                .map(RacingCarCurrentStatus::position)
                .collect(Collectors.toList());

        Position boundPosition = new Position(NUMBER_OF_TRIAL);

        assertThat(carPositions).allMatch(boundPosition::isAheadOf);
    }

    private RacingGameResult playTestGame(Moveable moveable) {
        RacingGame racingGame = RacingGame.of(RACING_CAR_NAMES, NUMBER_OF_TRIAL, moveable);
        return racingGame.start();
    }

    @DisplayName("정적 팩토리 메서드 생성자 테스트")
    @Test
    void ofTest() {
        String[] namesOfCar = {"more", "much", "less"};
        int tryCount = 5;
        Moveable moveable = new AlwaysMove();
        assertThatNoException().isThrownBy(() -> RacingGame.of(namesOfCar, tryCount, moveable));
    }
}