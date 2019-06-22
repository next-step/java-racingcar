package edu.nextstep.racing.view;

import edu.nextstep.racing.domain.Cars;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 18:39
 */
public class ResultView {
    private static final String DASH = "- ";
    private static final String COLON = " : ";
    private static final String COMMA = ",";

    public static void printRuslt(Cars cars) {
        int carsSize = cars.size();
        for (int i = 0; i < carsSize; i++) {
            String carName = cars.asList().get(i).getCarName();
            int carPosition = cars.asList().get(i).getCarPosition();

            resultPrint(carName, carPosition);
        }
        print();
    }
    
    public static void resultPrint(String carName, int position) {
        StringBuilder sb = new StringBuilder();
        sb.append(carName);
        sb.append(COLON);

        for (int i = 0; i < position; i++) {
            sb.append(DASH);
        }
        System.out.println(sb.toString());
    }

    public static void print() {
        System.out.println();
    }

}
