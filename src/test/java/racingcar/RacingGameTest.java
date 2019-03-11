package racingcar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RacingGameTest {
    RacingGame racingGame;

    @Test
    public void 차3대_레이싱2회_전진과멈춤_각각한번씩() {
        racingGame = new RacingGame(2);
        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            cars.add(new Car());
        }
        racingGame.race(cars, new FixedNumberGenerator(1));
        for (Car car : cars) {
            assertThat(car.getPosition(), is(0));
        }
        racingGame.race(cars, new FixedNumberGenerator(5));
        for (Car car : cars) {
            assertThat(car.getPosition(), is(1));
        }
    }

    @Test
    public void 차1대_레이싱10회_멈춤4회_전진6회() {
        racingGame = new RacingGame(10);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());

        for (int i = 0; i < 10; i++) {
            racingGame.race(cars, new FixedNumberGenerator(i));
        }
        assertThat(cars.get(0).getPosition(), is(6));
    }
}