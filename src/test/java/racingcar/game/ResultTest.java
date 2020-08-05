package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Cars;
import racingcar.car.CountOfCars;
import racingcar.engine.FixedGoPowerEngine;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {
    @DisplayName("N번째 라운드 결과 객체 생성")
    @Test
    void newInstance() {
        //given
        CountOfCars countOfCars = CountOfCars.newInstance(3);
        Cars cars = Cars.newInstance(countOfCars, new FixedGoPowerEngine());
        cars.move();

        //when
        Result result = Result.newInstance(cars);

        //then
        List<String> statusList = result.getStatusList();
        for (String status : statusList) {
            assertEquals("--", status);
        }
    }
}
