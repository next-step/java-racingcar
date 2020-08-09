package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.CarNames;
import racingcar.car.Cars;
import racingcar.engine.FixedGoPowerEngine;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {
    @DisplayName("N번째 라운드 결과 객체 생성")
    @Test
    void newInstance() {
        //given
        String nameValues = "pobi,crong,honux";
        CarNames carNames = CarNames.newInstance(nameValues);
        Cars cars = Cars.newInstance(carNames, new FixedGoPowerEngine());
        cars.move();

        //when
        Result result = Result.newInstance(cars);

        //then
        List<String> expected = Arrays.asList("pobi : -", "crong : -", "honux : -");
        List<String> statusList = result.getStatusList();

        assertEquals(expected.size(), statusList.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), statusList.get(i));
        }
    }
}
