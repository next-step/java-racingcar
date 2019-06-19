package edu.nextstep.racing.view;

import edu.nextstep.racing.model.Car;
import edu.nextstep.racing.model.Cars;
import edu.nextstep.racing.utils.ViewUtils;

import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-15 21:29
 */
public class ResultView {

    /*
    파라미터로 객체(자동차)를 받아 step 별로 출력
     */
    public void resultView(Cars cars) {
        for (Car car : cars.getCars()) {
            int carPosition = car.currentPosition();
            resultPrint(car, carPosition);
        }
        ViewUtils.print();
    }

    public void printWinnerPlayer(List<Car> cars) {
        ViewUtils.printWinner(cars);
    }

    private void resultPrint(Car car, int position) {
        ViewUtils.combinDash(car, position);
    }
}