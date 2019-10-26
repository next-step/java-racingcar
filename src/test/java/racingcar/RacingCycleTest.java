package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCycleTest {

    @Test
    @DisplayName("첫 RacingCycle 생성 시 car 위치는 0이다.")
    void createFirstRacingCycle() {
        //given
        int carNumber = 3;
        RacingCycle racingCycle = new RacingCycle(carNumber);

        //when
        List<Car> cars = racingCycle.get();

        //then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("두번째 RacingCycle 생성 후엔 이전 Cycle과 같은 위치를 가진다.")
    void createRacingCycle() {
        //given
        List<Car> cars = Arrays.asList(new Car(1), new Car(1));
        RacingCycle racingCycle = new RacingCycle(cars);

        //when
        List<Car> result = racingCycle.get();

        //then
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("cycle 실행하면 적어도 이전 위치보다 같거나 크다")
    void doCycle() {
        //given
        int carNumber = 3;
        RacingCycle racingCycle = new RacingCycle(carNumber);

        //when
        List<Car> result = racingCycle.get();

        //then
        assertThat(result).hasSize(3);
        assertThat(result.get(0).getLocation()).isGreaterThanOrEqualTo(0);
    }
}
