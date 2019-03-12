package racingcar.view;

import org.junit.Test;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    @Test
    public void 랭킹정렬_확인() {
        Car car1 = new Car("po", 5);
        Car car2 = new Car("jo", 2);
        Car car3 = new Car("gu", 5);
        Car car4 = new Car("yo", 4);

        List<Car> cars = new ArrayList<Car>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        OutputView.sortRanking(cars);

        for(Car car : cars) {
            System.out.println(car.getName() + " / " + car.getPosition());
        }

        assertThat(cars.get(0).getName()).isEqualTo(car1.getName());
        assertThat(cars.get(1).getName()).isEqualTo(car3.getName());
        assertThat(cars.get(2).getName()).isEqualTo(car4.getName());
        assertThat(cars.get(3).getName()).isEqualTo(car2.getName());
    }
}