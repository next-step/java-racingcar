package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        String carName = "a,b,c";
        racingGame = new RacingGame(carName, 2);

    }

    @Test
    @DisplayName("Cars 에 car 객체 추가되는 지 확인")
    void Cars_Car객체추가확인() {
        Cars cars = racingGame.cars();
        assertThat(cars.carList().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("carList 가 cars 를 반환하는 지 확인")
    void Cars_carList반환확인() {
        String carName = "a";
        Car car = new Car(carName);
        Cars cars = racingGame.cars();
        cars.addCar(car);
        assertThat(cars.carList().isEmpty()).isFalse();
    }

    @Test
    @DisplayName("maxPosition 값을 가진 자동차 명을 반환하는 지 확인")
    void Cars_최대위치자동차명확인() {
        Cars cars = racingGame.cars();
        for (Car car : cars.carList()) {
            if ("a".equals(car.carName())) {
                car.moveForward(6);
            } else {
                car.moveForward(0);
            }
        }
        assertThat(cars.maxPositionCars()).contains("a");
    }
}