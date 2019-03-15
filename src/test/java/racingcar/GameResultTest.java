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

        GameResult gameResult = new GameResult();
        List<Car> winners = gameResult.getWinner(cars);
        assertThat(winners).hasSize(1);
        assertThat(winners).containsExactly(winner);
    }
}
