package racingcar;

import org.junit.Before;
import org.junit.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.Referee;
import racingcar.utils.FixedNumberGenerator;

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
    public void 단독우승자_테스트() {
        racingGame = new RacingGame(3);
        racingGame.race(cars, new FixedNumberGenerator(5));
        racingGame.race(cars, new FixedNumberGenerator(6));

        Car c = cars.get(2);
        c.move(new FixedNumberGenerator(7));    // c만 힌킨 더 전진

        referee = new Referee();
        assertThat(referee.pickNamesOfWinners(cars).get(0), is("c"));
    }

    @Test
    public void 공동우승자_테스트() {
        Car a = cars.get(0);
        Car b = cars.get(1);
        Car c = cars.get(2);

        b.move(new FixedNumberGenerator(5));
        c.move(new FixedNumberGenerator(6));

        referee = new Referee();
        List<String> namesOfWinners = referee.pickNamesOfWinners(cars);
        assertThat(namesOfWinners, hasItems("b", "c"));
        assertThat(namesOfWinners, not(hasItems("a")));
    }
}
