package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    @DisplayName("주어진 횟수만큼 반복하고 턴마다 위치를 기록해 반환한다")
    @Test
    void raceRecordsEachTurn() {
        RacingGame game = new RacingGame(List.of("pobi", "crong"), 3);

        List<TurnResult> history = game.race(() -> 4);

        assertThat(history).containsExactly(
                new TurnResult(List.of(1, 1)),
                new TurnResult(List.of(2, 2)),
                new TurnResult(List.of(3, 3)));
    }

    @DisplayName("값이 3 이하면 턴을 반복해도 위치가 그대로다")
    @Test
    void raceWithoutMoving() {
        RacingGame game = new RacingGame(List.of("pobi", "crong"), 3);

        List<TurnResult> history = game.race(() -> 3);

        assertThat(history).containsExactly(
                new TurnResult(List.of(0, 0)),
                new TurnResult(List.of(0, 0)),
                new TurnResult(List.of(0, 0)));
    }
}
