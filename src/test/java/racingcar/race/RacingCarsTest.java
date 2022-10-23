package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    @DisplayName("일급객체로 관리하여 자동차 객체 추가")
    void addCar(){
        RacingCars racingCars = new RacingCars(new ArrayList<>());
        racingCars.addCar(new Car("a", 1));

        assertThat(racingCars.getRacingCars().size())
                .isEqualTo(1);
    }

}