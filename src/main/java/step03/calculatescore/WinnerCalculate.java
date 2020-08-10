package step03.calculatescore;

import step03.car.Car;

import java.util.Arrays;
import java.util.List;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:53 오후
 */
public class WinnerCalculate implements ResultCalculate{

    @Override
    public int resultCalculate(List<Car> cars) {
        Arrays.asList(cars);

        return cars.get(0).getMoveCount();
    }
}
