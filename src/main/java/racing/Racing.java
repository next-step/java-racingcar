package racing;

import java.util.List;
import ui.InputView;
import ui.ResultView;

public class Racing {

    public static void main(String[] args) {
        int carCount = InputView.getCarSize();
        int turnCount = InputView.getTurn();

        List<Car> cars = RacingCar.createCars(carCount);
        List<List<Integer>> carPositionsAtTurns = RacingCar.activeTurns(cars, turnCount);

        ResultView.printResult(carPositionsAtTurns);
    }

}
