package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.engine.FixedGoPowerEngine;
import racingcar.engine.RandomPowerEngine;
import racingcar.game.CarStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    private CarNames carNames;
    private Cars cars;

    @BeforeEach
    void setUp() {
        //given
        String nameValue = "pobi,crong,honux";
        carNames = CarNames.newInstance(nameValue);
        cars = Cars.newInstance(carNames, new FixedGoPowerEngine());
    }

    @DisplayName("N대의 자동차 생성")
    @Test
    void newCars() {
        //then
        List<Car> carList = cars.getCars();
        assertEquals(carNames.getNames().size(), carList.size());
    }

    @DisplayName("등록된 자동차들 1회씩 전진")
    @Test
    void moveAllCars() {
        //when
        List<Car> result = cars.move();

        //then
        int expected = 1;
        result.forEach(car -> assertEquals(expected, car.getPosition()));
    }

    @DisplayName("자동차 경주 현재상태 반환")
    @Test
    void snapshotStatus() {
        //when
        List<CarStatus> carStatuses = cars.snapshotStatus();

        //then
        assertEquals(carStatuses.size(), carNames.getNames().size());
    }
}
