package step03.calculatescore;

import org.junit.jupiter.api.BeforeEach;
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
 * Time : 10:53 오후
 */
class WinnerCalculateTest {

    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    public void init() {
        cars.add(new Car("junwoo", 2));
        cars.add(new Car("sunga", 3));
        cars.add(new Car("mesung",1));
    }

    @Test
    public void resultCalculateTest() {
        WinnerCalculate resultCalculate = new WinnerCalculate();
        int i = resultCalculate.resultCalculate(cars);
        assertThat(i).isEqualTo(3);
    }

}