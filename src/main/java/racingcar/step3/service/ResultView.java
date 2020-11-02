package racingcar.step3.service;

import racingcar.step3.domain.Car;

/**
 * Created : 2020-11-02 오전 8:25
 * Developer : Seo
 */
public class ResultView {
    public void printResult(InputView iv) {
        for (Car car : iv.getCars()) {
            System.out.println("Car " + car.getName() + " : " + (car.getDistance()));
        }
    }

}
