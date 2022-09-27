package racingCar;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    public static void main(String[] args) {
        String carNames = InputView.printQuestionInputString(InputView.Q_CAR_NAMES);
//        int carNum = InputView.printQuestionInputInt(InputView.Q_CAR_NUMBER);
        int tryNum = InputView.printQuestionInputInt(InputView.Q_TRY_TIMES);

        Cars cars = new Cars(new ArrayList<>());
        cars = cars.createCars(carNames);

        ResultView.print_GameResult();

        for (int i = 0; i < tryNum; i++) {
            cars.playGame();
            ResultView.print_PlayResult(cars);
            System.out.println();
        }
    }


}
