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

    public List<Car> makingCar(final String[] carNum) {

        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNum.length; i++) {
            cars.add(new Car(carNum[i]));
        }

        return cars;
    }

}
