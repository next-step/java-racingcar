package racing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {

    @Test
    public void 자동차정렬() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move(5);
        car2.move(5);
        car3.move(5);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingCarRank.sortCars(cars);

        assertThat(cars.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(1).getTotalDistance());
        assertThat(cars.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(2).getTotalDistance());
        assertThat(cars.get(1).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(2).getTotalDistance());
    }

    @Test
    public void 자동차랭킹() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move(5);
        car2.move(5);
        car3.move(5);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        RacingCarRank.sortCars(cars);

        List<Car> winners = RacingCarRank.rankCars(cars);

        assertThat(winners.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(0).getTotalDistance());
        assertThat(winners.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(1).getTotalDistance());
        assertThat(winners.get(0).getTotalDistance()).isGreaterThanOrEqualTo(cars.get(2).getTotalDistance());
    }
}