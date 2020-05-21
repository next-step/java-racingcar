package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @DisplayName("RacingCars 생성시 입력한 자동차 개수와 RacingCars가 가진 자동차의 수는 동일하다")
    @Test
    public void getAllTest() {
        RacingCars racingCars = new RacingCars(IntStream.range(0, 10)
                .mapToObj(name -> RacingCar.create(Integer.toString(name)))
                .collect(Collectors.toList()));

        assertThat(racingCars.getAll()).hasSize(10);
    }

    @DisplayName("모든 자동차의 포지션이 동일하면 우승자의 수는 자동차의 수와 일치한다")
    @Test
    public void getWinnerTest() {
        RacingCars racingCars = new RacingCars(IntStream.range(0, 10)
                .mapToObj(name -> RacingCar.create(Integer.toString(name)))
                .collect(Collectors.toList()));

        assertThat(racingCars.getWinners()).hasSize(10);
    }
}
