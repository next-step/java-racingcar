package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.controller.CarRacingController;
import step3.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    CarRacingController carRacingController = new CarRacingController();
    Car car;

    @BeforeEach
    void beforeEach(){
        car = new Car();
    }

    @Test
    @DisplayName("입력된 숫자가 4 미만인 경우 자동차는 정지해있어야 한다.")
    void moveCar_under4(){
        carRacingController.moveCar(3, car);
        assertThat(car.getMoveCnt()).isEqualTo(1);
    }

    @Test
    @DisplayName("입력된 숫자가 4 이상인 경우 자동차는 움직여야 한다.")
    void moveCar_over4() {
        carRacingController.moveCar(4, car);
        assertThat(car.getMoveCnt()).isEqualTo(2);
    }
}