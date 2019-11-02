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
        List<Car> init = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        RacingCycle racingCycle = new RacingCycle(init);

        //when
        List<Car> cars = racingCycle.getCycle();

        //then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getLocation()).isLessThanOrEqualTo(1);
    }


    @Test
    @DisplayName("cycle 실행하면 적어도 이전 위치보다 같거나 크다")
    void doCycle() {
        //given
        List<Car> init = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));

        //when
        RacingCycle racingCycle = new RacingCycle(init);

        //then
        List<Car> result = racingCycle.getCycle();
        assertThat(result).hasSize(3);
        assertThat(result.get(0).getLocation()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("해당 cycle 실행 시 우승자를 기록한다.")
    void findWinners() {
        //given
        List<Car> init = Arrays.asList(new Car("car1", 0),
                new Car("car2", 5),
                new Car("car3", 0));


        //when
        RacingCycle racingCycle = new RacingCycle(init);

        //then
        List<String> winners = racingCycle.findWinners();
        assertThat(winners).hasSize(1);
        assertThat(winners.get(0)).isEqualTo("car2");
    }
}
