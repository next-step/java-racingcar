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
}
