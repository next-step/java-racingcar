package racing;

import org.junit.jupiter.api.Test;
import racing.domain.Judge;
import racing.domain.RacingCar;
import racing.domain.RacingCars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {

    @Test
    void 단일_우승자() {
        RacingCars racingCars = new RacingCars(List.of(
                new RacingCar("audi", 2),
                new RacingCar("bmw", 3),
                new RacingCar("benz", 1)));
        assertThat(Judge.selectWinners(racingCars)).containsExactly("bmw");
    }

    @Test
    void 여러_우승자() {
        RacingCars racingCars = new RacingCars(List.of(
                new RacingCar("audi", 3),
                new RacingCar("bmw", 3),
                new RacingCar("benz", 1)));
        assertThat(Judge.selectWinners(racingCars)).hasSize(2);
    }
}
