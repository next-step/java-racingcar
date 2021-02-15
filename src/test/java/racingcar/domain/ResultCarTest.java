package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultCarTest {

    @DisplayName("차의 이름을 잘 가져오는지 확인")
    @Test
    void getCar() {
        ResultCar resultCar = new ResultCar("car1", 0);

        assertThat(resultCar.getCarName()).isEqualTo("car1");
    }

    @DisplayName("차의 위치를 잘 가져오는지 확인")
    @Test
    void getLocation() {
        ResultCar resultCar = new ResultCar("car1", 0);

        assertThat(resultCar.getLocation()).isEqualTo(0);
    }
}