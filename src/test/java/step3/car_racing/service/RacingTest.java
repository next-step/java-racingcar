package step3.car_racing.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.car_racing.model.Cars;
import step3.car_racing.util.WinnerUtil;

import java.util.List;

class RacingTest {

    @Test
    @DisplayName("최종 우승자 찾기")
    void findWinner() {
        // given
        List<String> carNameList = List.of("123", "456");
        Cars cars = new Cars(carNameList);

        // when
        Racing racing = new Racing(cars);
        String winner = WinnerUtil.findWinner(racing.getRaceResult());


        // then
        System.out.println(winner);
    }
}