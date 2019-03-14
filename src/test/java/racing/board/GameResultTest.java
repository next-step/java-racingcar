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

        List<RacingCar> cars = Arrays.asList(new RacingCar(), new NamedRacingCar("pobi"));
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
        gameResult.addStep(Arrays.asList(new NamedRacingCar("pobi")));

        assertThat(gameResult.getWinners().size())
            .isGreaterThan(0);
    }

    @Test
    public void test_1회_이동후_우승자들이_같은_위치에_있는지() {
        List<RacingCar> cars = Arrays.asList(new NamedRacingCar("pobi"));
        cars.forEach(car -> car.move(RacingCar.THRESHOLD_POWER));

        GameResult gameResult = new GameResult();
        gameResult.addStep(cars);

        assertThat(gameResult.getWinners())
                .allMatch(car -> car.compareTo(cars.get(0)) == 0);
    }
}