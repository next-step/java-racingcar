package racingcar;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RacingGameTest {
    RacingGame racingGame;

    @Before
    public void setUp() throws Exception {
        racingGame = new RacingGame(5);
    }

    @Test
    public void 차한대_전진2회_멈춤3회() {
        int[] testNumbers = {4, 5, 0, 0, 0};
        Car car = new Car();
        racingGame.race(car, testNumbers);
        assertThat(car.getRacingPath(), is("--"));
    }

    @Test
    public void 차세대_전진3회_멈춤2회() {
        int[] testNumbers2 = {2, 1, 8, 6, 7};
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            cars.add(new Car());
        }

        racingGame.start(cars, new FixedNumberGenerator(testNumbers2));
        for (Car car : cars) {
            assertThat(car.getRacingPath(), is("---"));
        }
    }
}