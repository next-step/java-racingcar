package racingcar.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    @DisplayName("일급객체로 관리하여 자동차 객체 1개 추가")
    void addOneCar(){
        String[] names = {"a"};
        RacingCars racingCars = RacingCars.of(names);

        int numberOfCar = racingCars.getRacingCars().size();

        assertThat(numberOfCar).isEqualTo(1);
    }

    @Test
    @DisplayName("일급객체로 관리하여 자동차 객체 다수 추가")
    void addCars(){
        String[] names = {"a","b","c"};
        RacingCars racingCars = RacingCars.of(names);

        int numberOfCar = racingCars.getRacingCars().size();

        assertThat(numberOfCar).isEqualTo(3);
    }

}