package race;

import race.Utils.InputUtils;
import race.View.ResultView;
import race.vehicle.Vehicles;

public class playGame {
    public static void main(String[] args) {
        Vehicles vehicles = new Vehicles(InputUtils.inputCarView());
        ResultView resultView = new ResultView(vehicles.getList());
        resultView.printResult(InputUtils.inputMoveView());
    }
}