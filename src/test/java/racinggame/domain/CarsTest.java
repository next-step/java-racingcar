package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차 이름 리스트를 전달하여 Cars 객체가 정상 생성된다.")
    void initTest() {
        Cars cars = initCars();
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("getMaxPosition 메서드가 가장높은 위치의 Car position을 반환한다.")
    void getMaxPositionTest() {
        Cars cars = initCars();
        int correctMoveNumber = 5;
        cars.getCarList().get(0).move(correctMoveNumber);
        cars.getCarList().get(0).move(correctMoveNumber);
        cars.getCarList().get(1).move(correctMoveNumber);
        assertThat(cars.getMaxPosition()).isEqualTo(2);
    }

    private Cars initCars() {
        List<String> carNames = List.of("자동차1", "자동차2", "자동차3");
        return new Cars(carNames);
    }
}