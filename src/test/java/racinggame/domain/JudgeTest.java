package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class JudgeTest {

    @Test
    void 우승자_판단() {
        // given
        RacingCars racingCars = new RacingCars("car1,car2,car2");
        racingCars.get().get(0).forward();

        // when
        List<String> winners = Judge.getWinners(racingCars);

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.contains("car1")).isTrue();
    }
}
