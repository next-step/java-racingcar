package race;

import race.util.InputUtils;
import race.view.ResultView;
import race.vehicle.Cars;

public class PlayGame {
    public static void main(String[] args) {
        Cars cars = new Cars(InputUtils.inputCarView());
        ResultView resultView = new ResultView(cars.getCars());
        resultView.printResult(InputUtils.inputMoveView());
    }
}