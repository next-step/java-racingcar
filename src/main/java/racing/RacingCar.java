package racing;

import java.util.List;
import view.InputView;
import view.ResultView;

public class RacingCar {

//    public static void main(String[] args) {
//        int carCount = InputView.getCarSize();
//        int turnCount = InputView.getTurn();
//
//        List<Car> cars = Car.createCars("a,b,c");
//        List<List<Integer>> carPositionsAtTurns = Racing.activeTurns(cars, turnCount);
//
//        ResultView.printResult(carPositionsAtTurns);
//    }
    public static void main(String[] args) {
//        int carCount = InputView.getCarSize();

        int turnCount = InputView.getTurn();

        RacingSession session = RacingSession.of("a,b,c");
        List<List<Integer>> carPositionsAtTurns = session.startRacing(turnCount);

//        List<Car> cars = Car.createCars("a,b,c");
//        List<List<Integer>> carPositionsAtTurns = Racing.activeTurns(cars, turnCount);

        ResultView.printResult(carPositionsAtTurns);
    }

}
