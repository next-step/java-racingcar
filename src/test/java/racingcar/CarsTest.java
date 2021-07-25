package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("주어진 개수만큼 자동차 객체 생성 확인")
    @Test
    void initCars(){
        Cars cars = new Cars(3);
        assertThat(cars.countCars()).isEqualTo(3);
    }
}
