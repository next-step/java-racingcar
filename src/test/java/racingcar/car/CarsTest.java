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
        CountOfCars countOfCars = CountOfCars.newInstance(4);

        //when
        Cars cars = Cars.newInstance(countOfCars, new RandomPowerEngine());

        //then
        List<Car> carList = cars.getCars();
        assertEquals(countOfCars.getCount(), carList.size());
    }

    @DisplayName("등록된 자동차들 1회씩 전진")
    @Test
    void moveAllCars() {
        //given
        CountOfCars countOfCars = CountOfCars.newInstance(3);
        Cars cars = Cars.newInstance(countOfCars, new FixedGoPowerEngine());

        //when
        List<Car> result = cars.move();

        //then
        result.forEach(car -> assertEquals(2, car.getPosition()));
    }
}
