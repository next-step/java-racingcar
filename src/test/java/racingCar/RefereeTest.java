package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingCar.domain.Car;
import racingCar.domain.Referee;

class RefereeTest {

    @Test
    @DisplayName("우승자를 정확하게 선출하는지 확인한다.")
    void test1() {
        Car car1 = new Car(1);
        Car car2 = new Car(3);
        Car car3 = new Car(2);
        List<Car> cars = Arrays.asList(car1, car2, car3);

        assertThat(Referee.findWinners(cars)).contains(car2);
    }

    @Test
    @DisplayName("2명 이상의 우승자를 선출할 수 있는지 확인한다.")
    void test2() {
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(2);
        List<Car> cars = Arrays.asList(car1, car2, car3);
        assertThat(Referee.findWinners(cars)).contains(car2, car3);
    }
}
