package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {
    @Test
    public void check_winner_if_correct() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("a", 2);
        Car car2 = new Car("b", 2);
        Car car3 = new Car("c", 1);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingGameResult racingGameResult = new RacingGameResult();
        racingGameResult.createWinner(cars);

        assertThat(racingGameResult.getWinner()).hasSize(2);
    }

    @Test
    public void check_add_round_result_well() {
        RoundResult roundResult1 = new RoundResult(1, new ArrayList<>());
        RoundResult roundResult2 = new RoundResult(1, new ArrayList<>());

        RacingGameResult racingGameResult = new RacingGameResult();
        racingGameResult.addRoundResult(roundResult1);
        racingGameResult.addRoundResult(roundResult2);

        assertThat(racingGameResult.getRoundResults()).hasSize(2);
    }
}
