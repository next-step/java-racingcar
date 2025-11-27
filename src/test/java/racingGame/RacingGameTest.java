package racingGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("항상 이동하는 전략을 사용하면 tryNo 만큼 라운드 진행 후 모든 자동차의 위치가 tryNo가 된다")
    void race_withAlwaysMoveStrategy_allCarsMoveEveryRound() {
        int tryNo = 3;
        RacingGame game = new RacingGame(
            Arrays.asList("a", "b", "c"),
            tryNo,
            () -> true
        );

        while (game.hasNextRound()) {
            game.race();
        }

        List<Car> cars = game.getCars();

        assertThat(cars)
            .hasSize(3)
            .allSatisfy(car -> assertThat(car.position()).isEqualTo(tryNo));

        List<String> winners = game.findWinners();
        assertThat(winners).containsExactlyInAnyOrder("a", "b", "c");
    }

    @Test
    @DisplayName("서로 다른 전략을 사용하면 위치가 가장 큰 자동차(들)가 우승자가 된다")
    void winners_returnsCarsWithMaxPosition() {
        List<String> names = Arrays.asList("a", "b", "c");
        MoveStrategy[] strategies = new MoveStrategy[]{
            () -> true,   // a: 이동
            () -> false,  // b: 정지
            () -> true    // c: 이동
        };

        RacingGame game = new RacingGameWithCustomStrategies(names, 1, strategies);

        while (game.hasNextRound()) {
            game.race();
        }

        List<String> winners = game.findWinners();

        assertThat(winners).containsExactlyInAnyOrder("a", "c");
    }

    @Test
    @DisplayName("hasNextRound는 tryNo만큼 race()가 호출되면 false를 반환한다")
    void hasNextRound_becomesFalseAfterEnoughRounds() {
        RacingGame game = new RacingGame(Arrays.asList("a"), 2, () -> true);

        assertThat(game.hasNextRound()).isTrue();

        game.race();
        assertThat(game.hasNextRound()).isTrue();

        game.race();
        assertThat(game.hasNextRound()).isFalse();
    }

    static class RacingGameWithCustomStrategies extends RacingGame {
        private final MoveStrategy[] strategies;

        public RacingGameWithCustomStrategies(List<String> names,
            int tryCount,
            MoveStrategy[] strategies) {
            super(names, tryCount, () -> false); // 기본 전략은 사용하지 않음
            this.strategies = strategies;
        }

        @Override
        protected void moveCars() {
            List<Car> cars = getCars();
            for (int i = 0; i < cars.size(); i++) {
                cars.get(i).move(strategies[i]);
            }
        }
    }
}
