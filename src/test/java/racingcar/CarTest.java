package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    Car car;
    Random random;

    @BeforeEach
    void setUpCar() {
        car = new Car("pobi", 0);
        random = new Random();
    }

    @Test
    @DisplayName("랜덤값 4이상의 경우 전진 테스트")
    void randomValueTest() {
        int tryNumber = 5;
        int result = 0;

        for(int i = 0; i < tryNumber; i++){
            int randomNumber = random.nextInt(10);
            result = car.move(randomNumber);
        }

        assertThat(car.getMoveSpace()).isEqualTo(result);
    }

    @Test
    @DisplayName("3대의 차 생성하기")
    void createCarsTest() {
        int carNumber = 3;
        String[] carNames = "pobi,crong,honux".split(",");

        List<Car> cars = Car.createCars(carNames, carNames.length);

        assertThat(cars.size()).isEqualTo(carNumber);
    }

    @Test
    @DisplayName("자동차 이름 부여하기")
    void createCars() {
        Car car = new Car("pobi", 0);
        assertThat(car.getName()).isEqualTo("pobi");
    }

}