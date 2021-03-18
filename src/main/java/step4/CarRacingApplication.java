package step4;

import step4.model.CarRacingGame;
import step4.model.Cars;
import step4.model.RandomMoveStrategy;
import step4.view.InputView;
import step4.view.OutputView;

public class CarRacingApplication {
    public static void main(String[] args) {
        OutputView.enterNamesOfCars();
        String names = InputView.getInput();
        OutputView.enterNumberOfRounds();
        int numberOfRounds = InputView.getNumberInput();

        CarRacingGame carRacingGame = new CarRacingGame(InputView.splitInput(names), numberOfRounds);

        OutputView.printExecutionResults();

        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        while(carRacingGame.racing()){
            carRacingGame.race(randomMoveStrategy);
            OutputView.printCarRacing(carRacingGame.Cars());
        }
        
        OutputView.printWinners(carRacingGame.Winners());
    }
}
