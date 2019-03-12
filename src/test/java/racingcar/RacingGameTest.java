package racingcar;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class RacingGameTest {

    @Test
    public void move_테스트() {
        int carNumber = 3;
        RacingGame racingGame = new RacingGame(carNumber);
        List<Car> carPositions = racingGame.move();

        assertThat(carPositions.size()).isEqualTo(carNumber);
        ResultView.viewCars(carPositions);
        assertTrue(carPositions
                .stream()
                .anyMatch (car -> car.getPosition() == 0 || car.getPosition() == 1 ));
    }

}
