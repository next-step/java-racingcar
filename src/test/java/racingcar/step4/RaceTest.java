package racingcar.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceTest {

    @Test
    @DisplayName("우승자 출력 테스트")
    void 우승자출력(){
        String [] carNames = {"pobi","crong","honux"};
        List<Car> cars = Car.createCars(carNames);
        List<Car> racingCars = Race.startRaceGame(cars);
        assertThat(racingCars.size()).isBetween(0,carNames.length);
    }

}