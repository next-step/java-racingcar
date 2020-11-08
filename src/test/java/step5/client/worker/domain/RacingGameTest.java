package step5.client.worker.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step5.client.worker.domain.strategy.MovableStrategy;
import step5.client.worker.domain.strategy.SelectFarthestDistanceWinnerStrategy;
import step5.client.worker.domain.strategy.SelectWinnerStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private static final SelectWinnerStrategy SELECT_WINNER_STRATEGY = new SelectFarthestDistanceWinnerStrategy();
    private static final MovableStrategy MUST_MOVABLE = () -> true;
    private static final List<String> CAR_NAMES = Arrays.asList("CAR1", "CAR2", "CAR3");
    private static final int TEN_TIMES_ATTEMPT = 10;

    @DisplayName("getAllRacingGameResults")
    @Nested
    class GetAllRacingGameResults {
        @DisplayName("결과를 snapshot 리스트로 반환")
        @Test
        void return_snapshot_list() {
            // given
            final RacingGame racingGame = RacingGame.of(CAR_NAMES, MUST_MOVABLE, SELECT_WINNER_STRATEGY);

            // when
            racingGame.race(TEN_TIMES_ATTEMPT);
            final List<RacingGameRoundResult> racingGameRoundResults = racingGame.getAllRacingGameResults();
            
            // then
            assertThat(racingGameRoundResults).isNotEmpty();
        }

        @DisplayName("10번 시도 시 레이싱카는 10번 이동")
        @Test
        void cars_must_moved_ten_times() {
            // given
            final RacingGame racingGame = RacingGame.of(CAR_NAMES, MUST_MOVABLE);
            
            // when
            racingGame.race(TEN_TIMES_ATTEMPT);
            final List<RacingGameRoundResult> racingGameRoundResults = racingGame.getAllRacingGameResults();

            // then
            final RacingGameRoundResult lastRacingGameRoundResult = racingGameRoundResults.get(TEN_TIMES_ATTEMPT - 1);
            final boolean AllCarMovedAtTenTimes = lastRacingGameRoundResult.getCars()
                    .stream()
                    .mapToInt(Car::getPosition)
                    .allMatch(position -> position == TEN_TIMES_ATTEMPT);
            assertThat(AllCarMovedAtTenTimes).isTrue();
        }

        @DisplayName("모두 동일하게 이동시 모두 우승자로 선정")
        @Test
        void all_is_winner_if_all_car_moved_same() {
            // given
            final RacingGame racingGame = RacingGame.of(CAR_NAMES, MUST_MOVABLE);
            
            // when
            racingGame.race(TEN_TIMES_ATTEMPT);
            final List<RacingGameRoundResult> racingGameRoundResults = racingGame.getAllRacingGameResults();

            // then
            final List<String> winners = racingGame.selectWinnerNames();
            assertThat(winners).isEqualTo(CAR_NAMES);
        }
    }
}