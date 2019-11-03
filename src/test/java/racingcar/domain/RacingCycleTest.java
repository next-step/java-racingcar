package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCycleTest {

    @Test
    @DisplayName("첫 RacingCycle 생성 시 car 위치는 0 또는 1이다.")
    void createFirstRacingCycle() {
        //given
        List<String> init = Arrays.asList("car1", "car2", "car3");

        RacingCycle racingCycle = new RacingCycle(init);

        //when
        List<Car> cars = racingCycle.getCycle();

        //then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getLocation()).isLessThanOrEqualTo(1);
    }


}
