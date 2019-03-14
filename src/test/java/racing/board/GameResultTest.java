package racing.board;

import org.junit.*;
import racing.model.RacingCar;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameResultTest {

    @Test
    public void test_결과_없음() {
        GameResult gameResult = new GameResult(Arrays.asList());

        assertThat(gameResult.getWinners())
            .isEmpty();
    }

    @Test
    public void test_결과_있음() {
        GameResult gameResult = new GameResult(Arrays.asList(new RacingCar()));

        assertThat(gameResult.getWinners().size())
            .isGreaterThan(0);
    }

    @Test
    public void test_1회_이동후_같은_위치에_있는지() {
        List<RacingCar> cars = Arrays.asList(new RacingCar(), new RacingCar(), new RacingCar());
        cars.forEach(car -> car.move(RacingCar.THRESHOLD_POWER));

        GameResult gameResult = new GameResult(cars);

        assertThat(gameResult.getWinners())
                .allMatch(car -> car.compareTo(cars.get(0)) == 0);
    }
}