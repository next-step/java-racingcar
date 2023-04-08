package racing;

import racing.carRacing.Cars;
import racing.carRacing.Count;
import racing.carRacing.Stages;
import racing.carRacing.view.InputView;

public class Main {
    public static void main(String[] args) {
        Count numberOfCar = Count.createCount(InputView.askNumberOfCar());
        Count numberOfStage = Count.createCount(InputView.askNumberOfStage());

        Cars cars = new Cars(numberOfCar);
        Stages stages = new Stages(numberOfStage);

        stages.startGame(cars);

    }
}
