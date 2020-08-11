package step03.calculatescore;

import step03.car.Car;

import java.util.Collections;
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
        Collections.sort(cars);

        return cars.get(0).getMoveCount();
    }

    @Override
    public int getWinnerScore(List<Car> cars) {
        int winnerScore = resultCalculate(cars);

        return winnerScore;
    }
}
