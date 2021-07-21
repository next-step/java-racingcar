package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void createCarTest() {
        int carNumber = 1;
        List<Car> cars = Car.createCars(carNumber);

        assertThat(cars.get(0).getMoveSpace()).isEqualTo(0);
    }
}