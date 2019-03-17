package racingcar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultTest {

    @Test
    public void 우승자_구하기() {
        List<Car> cars = new ArrayList<>();
        Car winner = new Car("winner", 5);
        cars.add(winner);
        cars.add(new Car("sy",1));
        cars.add(new Car("dh",2));

        RacingResult result = new RacingResult(cars);

        assertThat(result.getWinners()).contains(winner);
    }

    @Test
    public void 우승자가_두명인_경우() {

        List<Car> cars = new ArrayList<>();
        Car winner = new Car("winner", 5);
        Car hs = new Car("hs", 5);
        cars.add(winner);
        cars.add(new Car("sy",1));
        cars.add(new Car("dh",2));
        cars.add(hs);

        RacingResult result = new RacingResult(cars);

        assertThat(result.getWinners()).contains(winner, hs);
    }
}
