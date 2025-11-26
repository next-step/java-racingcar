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
        String carNames = "a,b,c";
        int tryNo = 3;
        RacingGame game = new RacingGame(
            Arrays.asList("a", "b", "c"),
            tryNo,
            () -> true
        );

        while (game.isEnd()) {
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
            () -> true,
            () -> false,
            () -> true
        };

        RacingGame game = new RacingGameWithCustomStrategies(names, 1, strategies);

        while (game.isEnd()) {
            game.race();
        }

        List<String> winners = game.findWinners();

        assertThat(winners).containsExactlyInAnyOrder("a", "c");
    }

    @Test
    @DisplayName("isEnd는 tryNo만큼 race()가 호출되면 false를 반환한다")
    void isEnd_becomesFalseAfterEnoughRounds() {
        RacingGame game = new RacingGame(Arrays.asList("a"), 2, () -> true);

        assertThat(game.isEnd()).isTrue();

        game.race();
        assertThat(game.isEnd()).isTrue();

        game.race();
        assertThat(game.isEnd()).isFalse();
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
