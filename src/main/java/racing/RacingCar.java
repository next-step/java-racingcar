package racing;

import java.util.List;
import view.InputView;
import view.ResultView;

public class RacingCar {

    public static void main(String[] args) {
        int carCount = InputView.getCarSize();
        int turnCount = InputView.getTurn();

        List<Car> cars = Car.createCars(carCount);
        List<List<Integer>> carPositionsAtTurns = Racing.activeTurns(cars, turnCount);

        ResultView.printResult(carPositionsAtTurns);
    }

}
