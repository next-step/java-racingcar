package step4;

import step4.model.Cars;
import step4.model.RandomMoveStrategy;
import step4.view.InputView;
import step4.view.OutputView;

public class CarRacingApplication {
    public static void main(String[] args) {
        OutputView.enterNamesOfCars();
        String input = InputView.getInput();
        Cars cars = new Cars(InputView.splitInput(input));
        OutputView.enterNumberOfRounds();
        int numberOfRounds = InputView.getNumberInput();
        OutputView.printExecutionResults();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        for(int i=0; i<numberOfRounds; i++){
            cars.move(randomMoveStrategy);
            OutputView.printCarRacing(cars);
        }
        OutputView.printWinners(cars.getWinners());
    }
}
