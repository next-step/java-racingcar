package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.controller.CarController;

import static org.assertj.core.api.Assertions.*;

public class CarControllerTest {

    @DisplayName("사용자에게 입력받은 수만큼 자동차를 생성한다.")
    @Test
    void createCars() {
        // given
        CarController carController = new CarController();
        int numOfCars = 5;

        // when
        carController.createCarsOf(numOfCars);

        // then
        assertThat(carController.getCars().getNumOfCars()).isEqualTo(5);
    }

    @DisplayName("경주가 시작하면 임의의 수를 전달 받아 자동차를 앞으로 움직인다.")
    @Test
    void startRace() {
        // given
        CarController carController = new CarController();
        int numOfCars = 6;
        carController.createCarsOf(numOfCars);

        // when
        for (int i=0; i<numOfCars; i++) {
            carController.moveCar(i, i);
        }

        // then
        for (int i=0; i<numOfCars; i++) {
            if (i < 4) {
                assertThat(carController.getCars().findCarBy(i).getCurrentPosition()).isEqualTo(0);
                continue;
            }

            assertThat(carController.getCars().findCarBy(i).getCurrentPosition()).isEqualTo(1);
        }
    }
}
