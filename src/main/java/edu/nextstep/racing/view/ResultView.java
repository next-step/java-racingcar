package edu.nextstep.racing.view;

import edu.nextstep.racing.model.Car;

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

    private static final String OUTPUT_SYMBOL = "- ";

    /*
    파라미터로 객체(자동차)를 받아 step 별로 출력
     */
    public void resultView(List<Car> cars) {
        for (Car car : cars) {
            resultPrint(car);
        }
        print();
    }

    private void resultPrint(Car car) {
        for (int i = 0; i < car.currentPosition(); i++) {
            System.out.print(OUTPUT_SYMBOL);
        }
        System.out.println();
    }

    private void print() {
        System.out.println();
    }
}
