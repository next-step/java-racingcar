package racingcar.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.strategy.RandomMovingStrategyFixture;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsServiceTest {
    @DisplayName("moveAll 함수는 리스트의 모든 car 객체 movement를 RandomMovingStrategy 따라 변경한다.")
    @Test
    void moveAll() {
        // given
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("happy", 0);
        Car car2 = new Car("joy", 1);
        Car car3 = new Car("name", 2);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        Cars cars = new Cars(carList);
        CarsService carsService = new CarsService(new RandomMovingStrategyFixture(0));

        // when
        cars = carsService.moveAll(cars);

        // then
        assertThat(cars).isInstanceOf(Cars.class);
        assertThat(cars.getCar(0).getCarPosition().getPosition()).isEqualTo(0);
        assertThat(cars.getCar(1).getCarPosition().getPosition()).isEqualTo(2);
        assertThat(cars.getCar(2).getCarPosition().getPosition()).isEqualTo(3);
    }
}
