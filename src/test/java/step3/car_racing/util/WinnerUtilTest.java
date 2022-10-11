package step3.car_racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.car_racing.model.Cars;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinnerUtilTest {

    private static final String WINNER_MESSAGE = "가 최종 우승 했습니다.";

    @Test
    @DisplayName("이동거리가 동일하면 우승자가 중복되어 나온다.")
    void findWinner() {

        // given
        List<String> carNameList = List.of("이상원", "원상이");
        Cars cars = new Cars().initCars(carNameList);

        // when
        String winner = WinnerUtil.findWinner(cars);

        // then
        assertEquals(carNameList + WINNER_MESSAGE, winner);
    }
}