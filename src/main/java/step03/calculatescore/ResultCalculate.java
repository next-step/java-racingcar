package step03.calculatescore;

import step03.car.Car;

import java.util.List;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:52 오후
 */
public interface ResultCalculate {

    int resultCalculate(final List<Car> cars);

    int getWinnerScore(final List<Car> cars);
}
