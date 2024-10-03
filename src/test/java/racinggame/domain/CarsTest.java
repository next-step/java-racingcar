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

    private Cars initCars() {
        List<String> carNames = List.of("자동차1", "자동차2", "자동차3");
        Cars cars = new Cars(carNames);
        return cars;
    }
}