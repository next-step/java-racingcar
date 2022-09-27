package racingCar;

import java.util.ArrayList;

public class CarRacing {
    public static void main(String[] args) {
        String carNames = InputView.printQuestionInputString(InputView.Q_CAR_NAMES);
        int tryNum = InputView.printQuestionInputInt(InputView.Q_TRY_TIMES);

        Cars cars = new Cars(carNames);

        ResultView.printGameResult();

        for (int i = 0; i < tryNum; i++) {
            cars.playGame();
            ResultView.printPlayResult(cars);
            System.out.println();
        }

        ResultView.printWinners(cars.getWinners());
    }


}
