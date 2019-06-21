package edu.nextstep.racing.view;

import edu.nextstep.racing.model.Car;
import edu.nextstep.racing.model.Cars;

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

    private static final String DASH = "- ";
    private static final String COLON = " : ";
    private static final String COMMA = ",";


    public void resultView(Cars cars) {
        int carNumber = cars.getNumberOfCars();

        for (int i = 0; i < carNumber; i++) {
            Car targetCar = cars.getCarInformation(i);
            resultPrint(targetCar, targetCar.currentPosition());
        }

        this.print();
    }

    public void printWinnerPlayer(Cars winner) {
        String win = winner.getWinnersName().stream()
                .reduce((s1, s2) -> s1 + COMMA + s2)
                .get();
        System.out.println(win);
    }

    private void resultPrint(Car car, int position) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getCarName());
        sb.append(COLON);

        for (int i = 0; i < position; i++) {
            sb.append(DASH);
        }
        System.out.println(sb.toString());
    }

    private void print() {
        System.out.println();
    }
}
