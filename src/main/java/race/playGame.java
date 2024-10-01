package race;

import race.Utils.InputUtils;
import race.View.ResultView;
import race.vehicle.Cars;

public class playGame {
    public static void main(String[] args) {
        Cars cars = new Cars(InputUtils.inputCarView());
        ResultView resultView = new ResultView(cars.getCars());
        resultView.printResult(InputUtils.inputMoveView());
    }
}