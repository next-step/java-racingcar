package racingGame;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    @DisplayName("항상 이동하는 전략을 사용하면 매 라운드마다 모든 자동차의 위치가 1씩 증가한다")
    void race_withAlwaysMoveStrategy_positionsIncreaseEveryRound() {
        List<String> names = Arrays.asList("a", "b", "c");
        RacingGame game = new RacingGame(names, 3, () -> true);

        List<Round> rounds = game.race();

        assertThat(rounds).hasSize(3);

        assertThat(rounds.get(0).positions()).containsExactly(1, 1, 1);
        assertThat(rounds.get(1).positions()).containsExactly(2, 2, 2);
        assertThat(rounds.get(2).positions()).containsExactly(3, 3, 3);
    }

    @Test
    @DisplayName("절대 이동하지 않는 전략을 사용하면 모든 라운드에서 모든 자동차의 위치는 0이다")
    void race_withNeverMoveStrategy_neverMoves() {
        List<String> names = Arrays.asList("a", "b");
        RacingGame game = new RacingGame(names, 3, () -> false);

        List<Round> rounds = game.race();

        assertThat(rounds).hasSize(3);

        for (Round round : rounds) {
            assertThat(round.positions()).containsExactly(0, 0);
        }
    }

    @Test
    @DisplayName("자동차별로 다른 전략을 적용하면 각 자동차는 전략에 따라 개별적으로 이동한다")
    void race_withMixedCars_movesCorrectly() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");

        MoveStrategy[] strategies = {
            new AlwaysMoveStrategy(),
            new NeverMoveStrategy(),
            new AlwaysMoveStrategy()
        };

        RacingGame game = new RacingGameWithCustomStrategies(names, 3, strategies);

        List<Round> rounds = game.race();

        assertThat(rounds.get(0).positions()).containsExactly(1, 0, 1);
        assertThat(rounds.get(1).positions()).containsExactly(2, 0, 2);
        assertThat(rounds.get(2).positions()).containsExactly(3, 0, 3);
    }

    @Test
    @DisplayName("경주가 끝난 후 최종 위치가 가장 큰 자동차(복수 포함)가 우승자로 선정된다")
    void winners_returnsAllMaxPositionCars() {
        List<String> names = Arrays.asList("pobi", "crong", "honux");

        MoveStrategy[] strategies = {
            new AlwaysMoveStrategy(),   // pobi -> 3
            new NeverMoveStrategy(),    // crong -> 0
            new AlwaysMoveStrategy()    // honux -> 3
        };

        RacingGame game = new RacingGameWithCustomStrategies(names, 3, strategies);

        game.race();
        List<String> winners = game.winners();

        assertThat(winners).containsExactly("pobi", "honux");
    }

    /**
     * 테스트 전용 서브클래스 — 차마다 서로 다른 전략 주입을 위해
     */
    static class RacingGameWithCustomStrategies extends RacingGame {

        private final MoveStrategy[] strategies;

        public RacingGameWithCustomStrategies(List<String> names, int tryCount, MoveStrategy[] strategies) {
            super(names, tryCount, null);   // 기본 strategy 는 사용하지 않음
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
