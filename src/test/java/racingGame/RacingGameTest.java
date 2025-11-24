package racingGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("항상 이동하는 전략을 사용하면 매 라운드마다 모든 자동차의 위치가 1씩 증가한다")
    void race_withAlwaysMoveStrategy_positionsIncreaseEveryRound() {
        List<String> names = Arrays.asList("a", "b", "c");
        RacingGame game = new RacingGame(names, 3, () -> true);

        List<Round> rounds = game.race();

        assertThat(rounds).hasSize(3);

        assertThat(rounds.get(0).positions())
            .containsExactly(1, 1, 1);
        assertThat(rounds.get(1).positions())
            .containsExactly(2, 2, 2);
        assertThat(rounds.get(2).positions())
            .containsExactly(3, 3, 3);
    }

    @Test
    @DisplayName("위치가 가장 큰 자동차(들)가 우승자로 선택된다")
    void winners_returnsAllCarsWithMaxPosition() {
        List<String> names = Arrays.asList("a", "b", "c");
        MoveStrategy[] strategies = new MoveStrategy[] {
            () -> true,
            () -> false,
            () -> true
        };

        RacingGame game = new RacingGameWithCustomStrategies(names, 1, strategies);

        game.race();
        List<String> winners = game.winners();

        assertThat(winners).containsExactlyInAnyOrder("a", "c");
    }


    static class RacingGameWithCustomStrategies extends RacingGame {

        private final MoveStrategy[] strategies;

        public RacingGameWithCustomStrategies(List<String> names,
            int tryCount,
            MoveStrategy[] strategies) {
            super(names, tryCount, () -> false);
            this.strategies = strategies;
        }

        @Override
        protected void moveAllCars() {
            for (int i = 0; i < strategies.length; i++) {
                cars.get(i).move(strategies[i]);
            }
        }
    }
}
