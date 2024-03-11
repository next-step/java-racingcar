package racingcar.app;

import racingcar.Cars;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class CarRaceApp {

    public static void main(String[] args) {
        ResultView.printAnswerHowManyCars();
        int carCount = InputView.readInt();

        ResultView.printAnswerHowManyTrys();
        int tryCount = InputView.readInt();

        Cars cars = new Cars(carCount);
        ResultView.printExecuteResultString();
        while (tryCount-- > 0) {
            cars.move();
            ResultView.write(cars.toString());
        }
    }

}
