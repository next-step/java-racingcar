package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameResultTest {
    @Test
    public void check_ranking_if_correct() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        car1.move();
        car1.move();
        car2.move();
        car2.move();
        car2.move();
        car3.move();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingGameResult racingGameResult = new RacingGameResult();
        racingGameResult.createRanking(cars);

        assertThat(racingGameResult.getRanking().size()).isEqualTo(3);
        assertThat(racingGameResult.getRanking().get(0)).isEqualTo(car2);
        assertThat(racingGameResult.getRanking().get(1)).isEqualTo(car1);
        assertThat(racingGameResult.getRanking().get(2)).isEqualTo(car3);
    }

    @Test
    public void check_add_round_result_well() {
        RoundResult roundResult1 = new RoundResult(1, new ArrayList<>());
        RoundResult roundResult2 = new RoundResult(1, new ArrayList<>());

        RacingGameResult racingGameResult = new RacingGameResult();
        racingGameResult.addRoundResult(roundResult1);
        racingGameResult.addRoundResult(roundResult2);

        assertThat(racingGameResult.getRoundResults().size()).isEqualTo(2);
    }
}
