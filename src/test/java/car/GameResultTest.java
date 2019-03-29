package car;

import car.domain.Car;
import car.domain.GameResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    private final static List<Car> TEST_CARS = Arrays.asList(Car.getCarInstance("test1"), Car.getCarInstance("test2"), Car.getCarInstance("test3"));
    private GameResult gameResult;

    @Test
    public void 게임_결과_셋팅_확인() {
        gameResult = GameResult.createResultInstance(TEST_CARS);
        gameResult.getRoundResult();
        assertThat(gameResult.getRoundResult().size()).isEqualTo(TEST_CARS.size());
    }

    @Test
    public void 가장_많이움직인_MOVING_COUNT_반환() {
        TEST_CARS.get(1).move(4);
        gameResult = GameResult.createResultInstance(TEST_CARS);
        assertThat(gameResult.getMaxMovement()).isEqualTo(1);
    }

    @Test
    public void 승자_이름_반환_확인() {
        TEST_CARS.get(0).move(4);
        gameResult = GameResult.createResultInstance(TEST_CARS);
        assertThat(gameResult.getWinnerNames().get(0)).isEqualTo(TEST_CARS.get(0).getName());
    }
}
