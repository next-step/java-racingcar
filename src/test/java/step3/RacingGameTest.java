package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.game.CarFactory;
import step3.game.RacingGame;
import step3.random.RandomStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("움직일 수 있는 기회가 1번인 경우 RacingGame 경기가 정상적으로 작동하는지 체크한다")
    void startWithOneMoveTest() {
        // given
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(List.of(1, 0, 1)));

        // when
        RacingGame game = new RacingGame(1, new RandomStrategy() {
            private int index = 0;
            private final int[] values = {6, 2, 4};

            @Override
            public int generateRandomValue() {
                return values[index++];
            }
        }, CarFactory.createCars("a,b,c"));


        // then
        List<List<Integer>> actual = game.start().stream().map(list -> {
            List<Integer> positions = new ArrayList<>();
            list.forEach(gameHistory -> positions.add(gameHistory.getPosition()));
            return positions;
        }).collect(Collectors.toList());
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("움직일 수 있는 기회가 여러 번인 경우 RacingGame 경기가 정상적으로 작동하는지 체크한다")
    void startTest1() {
        // given
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(List.of(1, 0)));
        expected.add(new ArrayList<>(List.of(1, 1)));
        expected.add(new ArrayList<>(List.of(2, 1)));

        // when
        RacingGame game = new RacingGame(3, new RandomStrategy() {
            private int index = 0;
            private final int[] values = {6, 2, 3, 4, 5, 1};

            @Override
            public int generateRandomValue() {

                return values[index++];
            }
        }, CarFactory.createCars("a,b"));

        // then
        List<List<Integer>> actual = game.start().stream().map(list -> {
            List<Integer> positions = new ArrayList<>();
            list.forEach(gameHistory -> positions.add(gameHistory.getPosition()));
            return positions;
        }).collect(Collectors.toList());
        assertThat(actual).isEqualTo(expected);
    }

}
