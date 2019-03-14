package racingcar.domain.race;

import org.junit.Test;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RankingTest {

    @Test
    public void sortRanking() {

        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("po");
        Car car2 = new Car("jo");
        Car car3 = new Car("jay");

        for (int i = 0; i < 5; i++) {
            car3.move();
        }

        for (int i = 0; i < 2; i++) {
            car1.move();
        }

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        Ranking.sort(cars);

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }

        assertThat(cars.get(0).compareTo(cars.get(1))).isGreaterThan(0);
        assertThat(cars.get(1).compareTo(cars.get(2))).isGreaterThan(0);
        assertThat(cars.get(2).compareTo(cars.get(0))).isLessThan(0);
    }

    @Test
    public void 우승자_찾기() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("po");
        Car car2 = new Car("jo");
        Car car3 = new Car("jay");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        for (int i = 0; i < 5; i++) {
            car3.move();
            car1.move();
        }

        List<Car> winners = Ranking.findWinner(cars);

        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println("~wiiners~");

        for (Car car : winners) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }

        assertThat(winners.size()).isGreaterThanOrEqualTo(1);
    }
}