package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Cars;
import racingcar.car.CountOfCars;
import racingcar.engine.FixedGoPowerEngine;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultsTest {

    @DisplayName("한 라운드 결과 추가")
    @Test
    void addResult() {
        //given
        Results results = Results.newInstance();
        Cars cars = Cars.newInstance(CountOfCars.newInstance(2), new FixedGoPowerEngine());

        //when
        results.add(Result.newInstance(cars));

        //then
        List<Result> resultList = results.getResults();
        assertEquals(1, resultList.size());
    }
}