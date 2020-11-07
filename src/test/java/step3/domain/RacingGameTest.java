package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step3.domain.strategy.MovableStrategy;
import step3.domain.strategy.SelectFarthestDistanceWinnerStrategy;
import step3.domain.strategy.SelectWinnerStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private static final SelectWinnerStrategy SELECT_WINNER_STRATEGY = new SelectFarthestDistanceWinnerStrategy();
    private static final MovableStrategy MUST_MOVABLE = () -> true;
    private static final List<String> CAR_NAMES = Arrays.asList("CAR1", "CAR2", "CAR3");
    private static final int TEN_TIMES_ATTEMPT = 10;

    @DisplayName("run")
    @Nested
    class Run {
        @DisplayName("결과를 snapshot 리스트로 반환")
        @Test
        void return_snapshot_list() {
            // given
            final RacingGame racingGame = RacingGame.of(CAR_NAMES, MUST_MOVABLE, SELECT_WINNER_STRATEGY);

            // when
            final List<Snapshot> snapshots = racingGame.run(TEN_TIMES_ATTEMPT);

            // then
            assertThat(snapshots).isNotEmpty();
        }

        @DisplayName("10번 시도 시 레이싱카는 10번 이동")
        @Test
        void cars_must_moved_ten_times() {
            // given
            final RacingGame racingGame = RacingGame.of(CAR_NAMES, MUST_MOVABLE);
            // when
            final List<Snapshot> snapshots = racingGame.run(TEN_TIMES_ATTEMPT);

            // then
            final Snapshot lastSnapshot = snapshots.get(TEN_TIMES_ATTEMPT - 1);
            final List<CarRacingResult> lastCarRacingResults = lastSnapshot.getCarRacingResults();
            final boolean AllCarMovedAtTenTimes = lastCarRacingResults
                    .stream()
                    .mapToInt(CarRacingResult::getCarPosition)
                    .allMatch(position -> position == TEN_TIMES_ATTEMPT);
            assertThat(AllCarMovedAtTenTimes).isTrue();
        }

        @DisplayName("모두 동일하게 이동시 모두 우승자로 선정")
        @Test
        void all_is_winner_if_all_car_moved_same() {
            // given
            final RacingGame racingGame = RacingGame.of(CAR_NAMES, MUST_MOVABLE);
            // when
            racingGame.run(TEN_TIMES_ATTEMPT);

            // then
            final List<String> winners = racingGame.selectWinnerNames();
            assertThat(winners).isEqualTo(CAR_NAMES);
        }
    }
}