package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.NumberGeneratorImp;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp(){
//        cars = new Cars(new NumberGenerratorTest());
    }
    @Test
    @DisplayName("Cars 에 car 객체 추가되는 지 확인")
    void addCar() {
        Car car = new Car();
        cars.addCar(car);
        assertThat(cars.carList().size()).isEqualTo(1);
        assertThat(cars.carList().contains(car)).isTrue();
    }

    @Test
    @DisplayName("carList 가 cars 를 반환하는 지 확인")
    void carList() {
        Car car = new Car();
        cars.addCar(car);
        assertThat(cars.carList().isEmpty()).isFalse();
    }
}