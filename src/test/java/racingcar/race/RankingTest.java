package racingcar.race;

import org.junit.Before;
import org.junit.Test;
import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {

    Ranking ranking;
    private List<Car> cars = null;

    @Before
    public void setUp() throws Exception {

        cars = new ArrayList<Car>();

        Car car1 = new Car("po", 5);
        Car car2 = new Car("jo", 2);
        Car car3 = new Car("gu", 5);
        Car car4 = new Car("yo", 4);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        ranking = new Ranking(5, cars);
    }

    @Test
    public void winner_수_확인하기() {
        int winner = ranking.countWinner(cars);

        assertThat(winner).isEqualTo(2);
    }

    @Test
    public void 정렬결과_확인() {
        for(Car car : cars) {
            System.out.println(car.getName());
        }

        assertThat(cars.get(0).getName()).isEqualTo("po");
        assertThat(cars.get(1).getName()).isEqualTo("gu");
        assertThat(cars.get(2).getName()).isEqualTo("yo");
        assertThat(cars.get(3).getName()).isEqualTo("jo");
    }
}