package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class CarsTest {

    @Test
    @DisplayName("입력받은 숫자만큼 자동차 그룹 생성 테스트")
    void createCarList() {
        int numberOfCar = 10;
        Cars cars = new Cars();
        assertThat(cars.Cars(numberOfCar).size()).isEqualTo(numberOfCar);
    }
}