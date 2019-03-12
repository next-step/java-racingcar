package racingcar;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class RefereeTest {
    List<Car> cars;
    RacingGame racingGame;
    Referee referee;

    @Before
    public void setUp() throws Exception {
        cars = new ArrayList<>();
        String[] names = {"a", "b", "c"};
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    @Test
    public void 차3대_레이싱1회_모두전진의경우_우승자의_기록() {
        racingGame = new RacingGame(3);
        racingGame.race(cars, new FixedNumberGenerator(5));

        referee = new Referee();
        assertThat(referee.getMaxPosition(cars), is(1));
    }

    @Test
    public void 차3대_레이싱1회_첫차빼고전진의경우_우승자_리스트() {
        Car firstCar = cars.get(0);
        Car secondCar = cars.get(1);
        Car thirdCar = cars.get(2);

        secondCar.move(new FixedNumberGenerator(5));
        thirdCar.move(new FixedNumberGenerator(6));

        referee = new Referee();
        List<Car> winners = referee.getWinners(cars);
        assertThat(winners, hasItems(secondCar, thirdCar));
        assertThat(winners, not(hasItems(firstCar)));
    }
}