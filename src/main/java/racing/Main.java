package racing;

import racing.carRacing.CarNames;
import racing.carRacing.Cars;
import racing.carRacing.Count;
import racing.carRacing.Stages;
import racing.carRacing.view.InputView;
import racing.carRacing.view.OutputView;

public class Main {
    public static void main(String[] args) {
        CarNames carNames = CarNames.createCarNames(InputView.askCarsName());
        Count numberOfStage = Count.createCount(InputView.askNumberOfStage());

        Cars cars = Cars.initCars(carNames);
        Stages stages = new Stages(numberOfStage);

        OutputView.printResultMention();
        while (stages.isFinished()) {
            OutputView.printRemainStage(stages.currentStage());
            stages.startGame(cars);
            OutputView.printCarsStatus(cars);
        }
    }
}
