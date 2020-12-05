package step3;

import step3.domain.AdvanceCheckor;
import step3.domain.Cars;
import step3.domain.RandomGenerator;
import step3.domain.strategy.MovingStrategy;
import step3.domain.strategy.RandomMovingStrategy;

import static step3.view.InputView.inputMessageAboutCars;
import static step3.view.InputView.inputMessageAboutTry;
import static step3.view.OutputView.outputMessage;
import static step3.view.OutputView.outputMessageAboutMove;

public class CarController {
    public static void main(String[] args) {
        MovingStrategy strategy = new RandomMovingStrategy(new RandomGenerator(), new AdvanceCheckor());
        Cars cars = new Cars(inputMessageAboutCars());
        int numOfTry = inputMessageAboutTry();
        outputMessage();
        for (int i=0; i<numOfTry; i++) {
            cars.moveCars(strategy);
            outputMessageAboutMove(cars.getCars());
        }


    }
}
