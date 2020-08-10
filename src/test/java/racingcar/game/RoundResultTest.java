package racingcar.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.CarNames;
import racingcar.car.Cars;
import racingcar.engine.FixedGoPowerEngine;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RoundResultTest {
    private RoundResult roundResult;
    private String nameValues;

    @BeforeEach
    void setUp() {
        //given
        nameValues = "pobi,crong,honux";
        CarNames carNames = CarNames.newInstance(nameValues);
        Cars cars = Cars.newInstance(carNames, new FixedGoPowerEngine());
        cars.move();

        this.roundResult = RoundResult.newInstance(cars);
    }

    @DisplayName("N번째 라운드 결과 객체 생성")
    @Test
    void newInstance2() {
        //then
        List<CarStatus> carStatuses = roundResult.getCarStatuses();
        assertEquals(nameValues.split(",").length, carStatuses.size());
    }

    @DisplayName("현재 라운드 우승자목록 가져오기")
    @Test
    void determineWinners() {
        //when, then
        int winnerPosition = roundResult.maxPosition();
        assertThat(roundResult.determineWinners(winnerPosition)).containsExactly("pobi", "crong", "honux");
    }
}
