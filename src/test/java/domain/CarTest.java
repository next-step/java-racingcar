package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차를 입력한 정수 대 만큼 생성한다.")
    void createCar() {
        Random random = new Random();
        int numberOfCars = random.nextInt(1000);
        List<Car> carList = Car.createCarList(numberOfCars);
        assertThat(carList).hasSize(numberOfCars);
    }


    @Test
    @DisplayName("자동차의 움직임을 입력한 숫자의 횟수만큼 시도해본다.")
    void moveCar() {
        Random random = new Random();
        int numberOfAttempts = random.nextInt(1000);
        Car car = new Car(1);
        car.attemptMove(numberOfAttempts);

        // 0 과 1000 의 숫자 사이로 움직임
        assertThat(car.getMoveCount()).isBetween(0, 1000);
    }
}
