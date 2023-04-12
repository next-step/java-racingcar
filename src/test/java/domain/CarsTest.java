package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("자동차를 입력한 정수 대 만큼 생성한다.")
    void createCar() {
        int numberOfCars = 3;
        int attemptCount = 3;
        UserInput userInput = new UserInput(numberOfCars, attemptCount);
        Cars cars = new Cars(userInput);

        assertThat(cars.countCars()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차의 움직임을 입력한 숫자의 횟수만큼 시도해본다.")
    void moveCar() {
        int numberOfCars = 1;
        int attemptCount = 10;
        UserInput userInput = new UserInput(numberOfCars, attemptCount);
        Cars cars = new Cars(userInput);

        for (int i = 0; i < attemptCount; i++) {
            cars.makeCarsMove();
        }
        assertThat(cars.getDistance(0))
                .isNotEqualTo(0);

    }
}
