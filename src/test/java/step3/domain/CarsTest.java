package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarsTest {

    @DisplayName("주아진 자동차만큼 자동차를 생성한다.")
    @Test
    public void makeCars() {
        String[] carNames = {"ppo", "nana", "ttubi"};

        Cars cars = new Cars(carNames);

        assertThat(cars.getCars()).hasSize(carNames.length);
    }

    @DisplayName("주어진 자동차만큼 자동차를 생성하고 전진 또는 정지한다.")
    @Test
    public void moveForward() {
        final int go = 1;
        final int stop = 0;

        Car test1 = new Car("ppo");
        Car test2 = new Car("nana");
        Car test3 = new Car("bora");

        List<Car> carList = new ArrayList<>();
        carList.add(test1);
        carList.add(test2);
        carList.add(test3);

        Cars cars = new Cars(carList);
        cars.moveCars();

        assertThat(cars.getCars())
                .hasSize(carList.size())
                .allSatisfy(car -> {
                    assertThat(car.getCurrentPosition()).isIn(go, stop);
                });
    }
}
