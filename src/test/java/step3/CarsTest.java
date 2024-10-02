package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("4이상의 숫자가 주어졌을 때 모든 자동차의 위치는 1이어야 한다.")
    void 자동차_이동_4이상_숫자() {
        Car car1 = new Car("mina");
        Car car2 = new Car("susu");
        Car car3 = new Car("jina");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = new Cars(carList);

        CarEngine carEngine = new TestEngine(4);

        cars.moveAll(carEngine);

        assertThat(cars.getCarList().get(0).getPosition()).isEqualTo(1);
        assertThat(cars.getCarList().get(1).getPosition()).isEqualTo(1);
        assertThat(cars.getCarList().get(2).getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만의 숫자가 주어졌을 때 모든 자동차의 위치는 0이어야 한다.")
    void 자동차_이동_4미만_숫자() {
        Car car1 = new Car("mina");
        Car car2 = new Car("susu");
        Car car3 = new Car("jina");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = new Cars(carList);

        CarEngine carEngine = new TestEngine(3);

        cars.moveAll(carEngine);

        assertThat(cars.getCarList().get(0).getPosition()).isEqualTo(0);
        assertThat(cars.getCarList().get(1).getPosition()).isEqualTo(0);
        assertThat(cars.getCarList().get(2).getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("모든 자동차의 위치가 동일할 때, winner는 3명이어야 한다.")
    void winner() {
        Car car1 = new Car("mina");
        Car car2 = new Car("susu");
        Car car3 = new Car("jina");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = new Cars(carList);

        CarEngine carEngine = new TestEngine(4);

        cars.moveAll(carEngine);

        assertThat(cars.getWinner().size()).isEqualTo(3);
    }
}
