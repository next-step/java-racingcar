package step03.car;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:32 오후
 */
public class CarCenter {

    public List<Car> makingCar(int carNum) {

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
