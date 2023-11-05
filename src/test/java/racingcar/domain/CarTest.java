package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("자동차 도메인 테스트")
public class CarTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @DisplayName("랜덤 값에 따라 자동차가 멈추거나 전진한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,0","4,1"}, delimiter = ',')
    void stopOrMove(int randomValue, int expected) {
        Car car = new Car();
        car.stopOrMove(randomValue);
        Assertions.assertThat(car.getMoveCount()).isEqualTo(expected);
    }

    @DisplayName("생성된 자동차를 자동차 리스트에 추가한다.")
    @Test
    void addCar() {
        cars.addCar(new Car());
        Assertions.assertThat(cars.getNumberOfCar()).isEqualTo(1);
    }

    @DisplayName("추가한 자동차들이 자동차 리스트에 존재하는지 확인한다.")
    @Test
    void getAllCar() {
        Car car1 = new Car();
        Car car2 = new Car();
        cars.addCar(car1);
        cars.addCar(car2);
        Assertions.assertThat(cars.getAllCar()).contains(car1, car2);
    }
}
