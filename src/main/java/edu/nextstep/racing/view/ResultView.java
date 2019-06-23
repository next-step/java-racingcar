package edu.nextstep.racing.view;

import edu.nextstep.racing.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

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

    public static void printResult(List<Cars> cars) {
        for (Cars car : cars) {
            showStageResult(car);
        }
    }

    private static void resultPrint(String carName, int position) {
        StringBuilder sb = new StringBuilder();
        sb.append(carName);
        sb.append(COLON);

        for (int i = 0; i < position; i++) {
            sb.append(DASH);
        }
        System.out.println(sb.toString());
    }

    public static void resultWinPlayer(List<String> winPlayerNames) {
        String winPlater = winPlayerNames.stream()
                .collect(Collectors.joining(COMMA));

        System.out.println(winPlater + "가 최종 우승했습니다.");
    }

    public static void print() {
        System.out.println();
    }

    private static void showStageResult(Cars cars) {
        int carsSize = cars.size();
        for (int i = 0; i < carsSize; i++) {
            combineNameAndPosition(cars, i);
        }
        print();
    }

    private static void combineNameAndPosition(Cars cars, int index) {
        String carName = cars.asList().get(index).getCarName();
        int carPosition = cars.asList().get(index).getCarPosition();

        resultPrint(carName, carPosition);
    }

}
