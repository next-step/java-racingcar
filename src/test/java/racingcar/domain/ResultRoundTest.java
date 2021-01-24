package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultRoundTest {
    @DisplayName("차들의 정보를 잘 가져오는지 확인")
    @Test
    void getResultCars() {
        List<ResultCar> resultCars = new ArrayList<ResultCar>() {{
            add(new ResultCar("car1", 0));
            add(new ResultCar("car2", 3));
        }};
        ResultRound resultRound = new ResultRound(resultCars);

        assertThat(resultRound.getResultCars()).isEqualTo(resultCars);
    }
}