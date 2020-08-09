package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.engine.FixedGoPowerEngine;
import racingcar.engine.RandomPowerEngine;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    @DisplayName("N대의 자동차 생성")
    @Test
    void newCars() {
        //given
        String nameValue = "pobi,crong,honux";
        CarNames carNames = CarNames.newInstance(nameValue);

        //when
        Cars cars = Cars.newInstance(carNames, new RandomPowerEngine());

        //then
        List<Car> carList = cars.getCars();
        assertEquals(carNames.getNames().size(), carList.size());
    }

    @DisplayName("등록된 자동차들 1회씩 전진")
    @Test
    void moveAllCars() {
        //given
        String nameValue = "pobi,crong,honux";
        CarNames carNames = CarNames.newInstance(nameValue);
        Cars cars = Cars.newInstance(carNames, new FixedGoPowerEngine());

        //when
        List<Car> result = cars.move();

        //then
        int expected = 1;
        result.forEach(car -> assertEquals(expected, car.getPosition()));
    }
}
