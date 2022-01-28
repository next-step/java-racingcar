package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class JudgeTest {

    @Test
    void 우승자_판단() {
        RacingCar car1 = new RacingCar("car1", 2);
        RacingCar car2 = new RacingCar("car2", 2);
        RacingCar car3 = new RacingCar("car3", 3);

        RacingCars racingCars = new RacingCars("car1,car2,car2");
        racingCars.getRacingCars().get(0).forward();

        List<String> winners = Judge.getWinners(racingCars);

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.contains("car1")).isTrue();
    }
}
