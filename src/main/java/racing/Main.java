package racing;

import racing.carRacing.model.Cars;
import racing.carRacing.model.Count;
import racing.carRacing.model.RandomMovementStrategy;
import racing.carRacing.model.Stages;
import racing.carRacing.view.InputView;
import racing.carRacing.view.OutputView;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.askCarsName();
        Cars cars = Cars.initCars(carNames);

        Count numberOfStage = Count.createCount(InputView.askNumberOfStage());
        Stages stages = new Stages(numberOfStage);

        OutputView.printResultMention();
        while (stages.hasMoreStages()) {
            OutputView.printRemainStage(stages.currentStage());
            stages.startGame(cars, new RandomMovementStrategy());
            OutputView.printCarsStatus(cars);
        }
        OutputView.printWinner(cars.getWinners());
    }
}
