package racingcar.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.CarNames;
import racingcar.car.Cars;
import racingcar.engine.FixedGoPowerEngine;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ResultsTest {

    private Results results;
    private Cars cars;

    @BeforeEach
    void setUp() {
        results = Results.newInstance();
        String nameValues = "pobi,crong,honux";
        CarNames carNames = CarNames.newInstance(nameValues);
        cars = Cars.newInstance(carNames, new FixedGoPowerEngine());
    }

    @DisplayName("한 라운드 결과 추가")
    @Test
    void addResult() {
        //when
        results.add(Result.newInstance(cars));

        //then
        int expected = 1;
        List<Result> resultList = results.getResults();
        assertEquals(expected, resultList.size());
    }

    @DisplayName("우승자 출력")
    @Test
    void getWinnerList() {
        //given
        cars.move();

        //when
        results.add(Result.newInstance(cars));

        //then
        assertThat(results.getWinners()).containsExactly("pobi", "crong", "honux");
    }
}