package step3;

import step3.domain.AdvanceCheckor;
import step3.domain.Cars;
import step3.domain.RandomGenerator;
import step3.domain.strategy.RandomMovingStrategy;

import static step3.view.InputView.inputMessageAboutCars;
import static step3.view.InputView.inputMessageAboutTry;
import static step3.view.OutputView.outputMessage;
import static step3.view.OutputView.outputMessageAboutMove;

public class CarController {
    public static void main(String[] args) {

        Cars cars = new Cars(inputMessageAboutCars());

        int numOfTry = inputMessageAboutTry();

        outputMessage();
        for (int i=0; i<numOfTry; i++) {
            cars.moveCars(new RandomMovingStrategy(new RandomGenerator(), new AdvanceCheckor()));
            outputMessageAboutMove(cars.getCars());
        }


    }
}
