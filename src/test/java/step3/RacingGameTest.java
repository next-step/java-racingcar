package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.game.CarFactory;
import step3.game.GameRound;
import step3.game.RacingGame;
import step3.game.Car;
import step3.random.RandomStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("움직일 수 있는 기회가 1번인 경우 RacingGame 경기가 정상적으로 작동하는지 체크한다")
    void startWithOneMoveTest() {
        // given
        List<GameRound> expected = new ArrayList<>();
        expected.add(new GameRound(List.of(
                new Car("a", 1),
                new Car("b", 0),
                new Car("c", 1))));

        // when
        RacingGame game = new RacingGame(1, CarFactory.createCars("a,b,c"));
        RandomStrategy random = new RandomStrategy() {
            private int index = 0;
            private final int[] values = {6, 2, 4};

            @Override
            public int generateRandomValue() {
                return values[index++];
            }
        };

        // then
        assertThat(game.start(random)).isEqualTo(expected);
    }

    @Test
    @DisplayName("움직일 수 있는 기회가 여러 번인 경우 RacingGame 경기가 정상적으로 작동하는지 체크한다")
    void startTest1() {
        // given
        List<GameRound> expected = new ArrayList<>();
        expected.add(new GameRound(List.of(
                new Car("a", 1),
                new Car("b", 0))));
        expected.add(new GameRound(List.of(
                new Car("a", 1),
                new Car("b", 1))));
        expected.add(new GameRound(List.of(
                new Car("a", 2),
                new Car("b", 1))));

        // when
        RacingGame game = new RacingGame(3, CarFactory.createCars("a,b"));
        RandomStrategy random =  new RandomStrategy() {
            private int index = 0;
            private final int[] values = {6, 2, 3, 4, 5, 1};

            @Override
            public int generateRandomValue() {
                return values[index++];
            }
        };

        // then
        assertThat(game.start(random)).isEqualTo(expected);
    }
}
