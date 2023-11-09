package step4.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarControllerTest {

    @DisplayName("사용자에게 입력받은 이름 개수만큼 자동차를 생성한다.")
    @Test
    void createCars() {
        // given
        CarController carController = new CarController();
        String[] nameOfCars = {"hong","kim","lee","park","ahn"};

        // when
        carController.createCarsOf(nameOfCars);

        // then
        assertThat(carController.getCars().getNumOfCars()).isEqualTo(5);
    }

    @DisplayName("경주가 시작하면 임의의 수를 전달 받아 자동차를 앞으로 움직인다.")
    @Test
    void startRace() {
        // given
        CarController carController = new CarController();
        String[] nameOfCars = {"hong","kim","lee","park","ahn"};
        carController.createCarsOf(nameOfCars);

        // when
        for (int i=0; i<nameOfCars.length; i++) {
            carController.moveCar(i, i);
        }

        // then
        for (int i=0; i<nameOfCars.length; i++) {
            if (i < 4) {
                assertThat(carController.getCars().findCarBy(i).getCurrentPosition()).isEqualTo(0);
                continue;
            }

            assertThat(carController.getCars().findCarBy(i).getCurrentPosition()).isEqualTo(1);
        }
    }
}
