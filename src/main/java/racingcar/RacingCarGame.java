package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGame {
    public static void main(String...args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int carNum = inputView.viewNumberOfCars();
        int tryNum = inputView.viewNumberOfTry();

        RacingCar racingCar = new RacingCar(carNum, new RandomMove());

        resultView.printResultMessage();
        while(tryNum != 0) {
            racingCar.racingPlay();
            resultView.printResult(racingCar.getCarList());

            tryNum --;
        }
    }
}
