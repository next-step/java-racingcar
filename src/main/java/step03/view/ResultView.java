package step03.view;

import step03.calculatescore.ResultCalculate;
import step03.car.Car;
import step03.util.Util;

import java.util.List;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:15 오전
 */
public class ResultView {

    public void draw(final List<Car> cars) {
        System.out.println();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.print(car.getCarName()+" : ");
            drawLine(car);
        }
    }

    private void drawLine(final Car car) {
        for (int i = 0; i < car.getMoveCount(); i++) {
            System.out.print(Util.MOVESTRING);
        }
        System.out.println();
    }

    public void getWinnerScore(List<Car> cars, ResultCalculate resultCalculate) {
        int winnerScore = resultCalculate.resultCalculate(cars);
        System.out.println(winnerScore);
    }

}
