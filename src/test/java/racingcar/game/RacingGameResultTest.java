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

class RacingGameResultTest {

    private RacingGameResult racingGameResult;
    private Cars cars;

    @BeforeEach
    void setUp() {
        racingGameResult = RacingGameResult.newInstance();
        String nameValues = "pobi,crong,honux";
        CarNames carNames = CarNames.newInstance(nameValues);
        cars = Cars.newInstance(carNames, new FixedGoPowerEngine());
    }

    @DisplayName("한 라운드 결과 추가")
    @Test
    void addResult() {
        //when
        racingGameResult.add(RoundResult.newInstance(cars));

        //then
        int expected = 1;
        List<RoundResult> roundResultList = racingGameResult.getRoundResults();
        assertEquals(expected, roundResultList.size());
    }

    @DisplayName("우승자 출력")
    @Test
    void getWinnerList() {
        //given
        cars.move();

        //when
        racingGameResult.add(RoundResult.newInstance(cars));

        //then
        assertThat(racingGameResult.getWinners()).containsExactly("pobi", "crong", "honux");
    }
}