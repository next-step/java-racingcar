package racingcar.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.CarNames;
import racingcar.car.Cars;
import racingcar.engine.FixedGoPowerEngine;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {
    private Result result;

    @BeforeEach
    void setUp() {
        //given
        String nameValues = "pobi,crong,honux";
        CarNames carNames = CarNames.newInstance(nameValues);
        Cars cars = Cars.newInstance(carNames, new FixedGoPowerEngine());
        cars.move();

        this.result = Result.newInstance(cars);
    }

    @DisplayName("N번째 라운드 결과 객체 생성")
    @Test
    void newInstance() {
        //then
        List<String> expected = Arrays.asList("pobi : -", "crong : -", "honux : -");
        List<String> statusList = this.result.getStatusList();

        assertEquals(expected.size(), statusList.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), statusList.get(i));
        }
    }

    @DisplayName("N번째 라운드 선두 위치 확인")
    @Test
    void getMaxPosition() {
        int expected = 1;
        assertEquals(expected, this.result.getMaxPosition());
    }

    @DisplayName("현재 라운드 우승자목록 가져오기")
    @Test
    void getWinners() {
        //when, then
        assertThat(result.determineWinners()).containsExactly("pobi", "crong", "honux");
    }
}
