package racing.board;

import org.junit.*;
import racing.model.NamedRacingCar;
import racing.model.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    public void test_스텝_추가() {
        GameResult gameResult = new GameResult();

        List<RacingCar> cars = Arrays.asList(new RacingCar(), new RacingCar());
        assertThat(gameResult.addStep(cars)).isEqualTo(1);
        assertThat(gameResult.addStep(cars)).isEqualTo(2);
    }

    @Test
    public void test_결과_없음() {
        GameResult gameResult = new GameResult();

        assertThat(gameResult.getWinners())
            .isEmpty();
    }

    @Test
    public void test_결과_있음() {
        GameResult gameResult = new GameResult();
        gameResult.addStep(Arrays.asList(new RacingCar()));

        assertThat(gameResult.getWinners().size())
            .isGreaterThan(0);
    }

    @Test
    public void test_우승자들이_같은_위치에_있는지() {
        int winnerPosition = 2;
        List<RacingCar> cars = Arrays.asList(new RacingCar(winnerPosition),
                new RacingCar(winnerPosition), new RacingCar(winnerPosition - 1));

        GameResult gameResult = new GameResult();
        gameResult.addStep(cars);

        assertThat(gameResult.getWinners())
                .allMatch(car -> car.compareTo(new RacingCar(winnerPosition)) == 0);
    }
}