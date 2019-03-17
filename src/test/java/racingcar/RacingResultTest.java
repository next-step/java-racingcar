package racingcar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    public void 우승자_구하기() {
        List<Car> cars = new ArrayList<>();
        Car winner = new Car("winner", 5);
        cars.add(winner);
        cars.add(new Car("sy",1));
        cars.add(new Car("dh",2));

        List<Car> winners = RacingGameUtil.getWinner(cars);
        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly(winner);
    }

    @Test
    public void 포지션_가장큰_자동차_구하기() {
        int max = 9;
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("max", max));
        cars.add(new Car("sy", 3));
        cars.add(new Car("dh", 7));

        assertThat(RacingGameUtil.getMaxPositionFromCars(cars)).isEqualTo(max);

    }
}
