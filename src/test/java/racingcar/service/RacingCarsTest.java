package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarsTest {

    @Test
    @DisplayName("우승자 찾기 테스트")
    void winner() {
        Car pobi = new Car("pobi", 3);
        Car crong = new Car("crong", 2);
        Car honux = new Car("honux", 1);
        List<Car> cars = Arrays.asList(pobi, crong, honux);

        RacingCars racingCars = new RacingCars(cars);

        List<String> winners = racingCars.getWinner();

        assertThat(winners).hasSize(1);
        assertThat(winners).contains(pobi.getName());
    }

}
