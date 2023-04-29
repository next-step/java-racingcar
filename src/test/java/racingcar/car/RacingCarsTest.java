package racingcar.car;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RacingCarsTest {

    Car car1;
    Car car2;
    Car car3;

    @BeforeEach
    void before(){
        car1 = Car.from("car1");
        car2 = Car.from("car2");
        car3 = Car.from("car3");
    }

    @DisplayName("car.state가 가장 높은 car를 반환한다")
    @Test
    void test1(){
        car1.move(() -> 5);
        List<Car> cars = Lists.list(car1, car2, car3);
        RacingCars racingCars = new RacingCars(cars, () -> 0);

        List<Car> winners = racingCars.getWinners();
        Assertions.assertThat(winners.size()).isEqualTo(1);
        Assertions.assertThat(winners).contains(car1);
    }

    @DisplayName("가장 높은 state를 가진 car가 2개 이상이라면 모두 winner로 여긴다")
    @Test
    void test2(){
        car1.move(() -> 5);
        car2.move(() -> 5);
        List<Car> cars = Lists.list(car1, car2, car3);
        RacingCars racingCars = new RacingCars(cars, () -> 0);

        List<Car> winners = racingCars.getWinners();
        Assertions.assertThat(winners.size()).isEqualTo(2);
        Assertions.assertThat(winners).contains(car1, car2);
    }

}