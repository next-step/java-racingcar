package racingcar;

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
        Car car1 = new Car(0);
        Car car2 = new Car(1);
        Car car3 = new Car(2);
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
        Car car1 = new Car(0);
        cars.add(car1);

        // when
        Cars actual = new Cars(cars);

        // then
        assertThat(actual.getCar(0)).isInstanceOf(Car.class);
        assertThat(actual.getCar(0)).isEqualTo(car1);
    }

    @DisplayName("cars moveAll 함수는 리스트의 모든 car 객체 movement를 RandomMovingStrategy 따라 변경한다.")
    @Test
    void moveAll() {
        // given
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car(0);
        Car car2 = new Car(1);
        Car car3 = new Car(2);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        Cars cars = new Cars(carList);

        // when
        cars = cars.moveAll(new RandomMovingStrategy(0));

        // then
        assertThat(cars).isInstanceOf(Cars.class);
        assertThat(cars.getCar(0).getMovement()).isEqualTo(0);
        assertThat(cars.getCar(1).getMovement()).isEqualTo(2);
        assertThat(cars.getCar(2).getMovement()).isEqualTo(3);
    }
}
