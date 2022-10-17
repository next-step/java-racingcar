package step4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingCarGameTest {

    @Test
    void 우승자는_2명이상이_될수있다() {
        List<Car> racingCars = new ArrayList<>();
        racingCars.add(new Car("a", 1));
        racingCars.add(new Car("b", 2));
        racingCars.add(new Car("c", 3));
        racingCars.add(new Car("d", 3));
        racingCars.add(new Car("e", 3));

        List<Car> winners = RacingCarGame.getWinners(racingCars);
        assertThat(winners.size()).isGreaterThanOrEqualTo(2);
    }

    @Test
    void 게임을_1회_진행한_모든차는_거리가_1이하이다() {
        List<Car> racingCars = new ArrayList<>();
        racingCars.add(new Car("a"));
        racingCars.add(new Car("b"));
        racingCars.add(new Car("c"));
        racingCars.add(new Car("d"));
        racingCars.add(new Car("e"));
        RacingCarGame.tryOneRound(racingCars);

        assertThat(racingCars)
            .allSatisfy(car -> assertThat(car.getDistance())
            .isLessThanOrEqualTo(1));
    }
}
