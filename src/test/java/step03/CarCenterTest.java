package step03;

import org.junit.jupiter.api.Test;
import step03.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:34 오후
 */
class CarCenterTest {

    @Test
    public void makingCarTest() {

        int carNum = 3;

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }

        assertThat(cars.size()).isEqualTo(carNum);
    }
}