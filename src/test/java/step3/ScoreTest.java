package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ScoreTest {

    @Test
    @DisplayName("모든 자동차에 4이상의 숫자가 주어졌을 때 max score는 1이어야 한다.")
    void max_score_4이상() {
        int power = 4;
        Cars cars = setCars(power);

        int maxScore = Score.getMax(cars.getCarList());

        Assertions.assertThat(maxScore).isEqualTo(1);
    }

    @Test
    @DisplayName("모든 자동차에 4미만의 숫자가 주어졌을 때 max score는 0이어야 한다.")
    void max_score_4미만() {
        int power = 3;
        Cars cars = setCars(power);

        int maxScore = Score.getMax(cars.getCarList());

        Assertions.assertThat(maxScore).isEqualTo(0);
    }

    Cars setCars(int power) {
        Car car1 = new Car("mina");
        Car car2 = new Car("susu");
        Car car3 = new Car("jina");

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Cars cars = new Cars(carList);

        CarEngine carEngine = new TestEngine(power);

        cars.moveAll(carEngine);

        return cars;
    }
}
