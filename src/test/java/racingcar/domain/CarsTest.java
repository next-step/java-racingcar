package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    @DisplayName("cars List Collection 초기값을 이용해 Cars 객체를 생성한다.")
    @Test
    void create() {
        // given
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("happy");
        Car car2 = new Car("joy");
        Car car3 = new Car("name");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        // when
        Cars actual = new Cars(cars);

        // then
        assertThat(actual).isInstanceOf(Cars.class);
        assertThat(actual.getSize()).isEqualTo(cars.size());
    }

    @DisplayName("cars getCar는 List<Car>.get(index)한 것과 동일하다.")
    @Test
    void getCar() {
        // given
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("happy");
        cars.add(car1);

        // when
        Cars actual = new Cars(cars);

        // then
        assertThat(actual.getCar(0)).isInstanceOf(Car.class);
        assertThat(actual.getCar(0)).isEqualTo(car1);
    }

    @DisplayName("cars getWinners 함수는 모든 car 객체중에서 movement가 가장 큰 우승자를 찾고 이름을 출력한다. 우승자는 한 명 이상일 수 있다.")
    @Test
    void getWinners() {
        // given
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("happy", 5);
        Car car2 = new Car("joy", 5);
        Car car3 = new Car("name", 4);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        Cars cars = new Cars(carList);

        // when
        String winners = cars.getWinners();

        // then
        assertThat(winners).isEqualTo("happy, joy");
    }
}
