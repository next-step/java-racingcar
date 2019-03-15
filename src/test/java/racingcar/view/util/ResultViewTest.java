package racingcar.view.util;

import org.junit.Test;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultViewTest {

    //TODO : addAll 적용해보기
    @Test
    public void result() {
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

        for (int i = 0; i < 2; i++) {
            car2.move();
        }

        ResultView.result(cars, 5);

    }

    @Test
    public void winner() {
    }
}