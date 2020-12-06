package step4;

import step4.domain.Cars;
import step4.domain.RandomGenerator;
import step4.domain.judge.Judge;
import step4.domain.judge.LongPositionJudge;
import step4.domain.strategy.MovingStrategy;
import step4.domain.strategy.RandomMovingStrategy;

import static step4.domain.CarFactory.produceCars;
import static step4.view.InputView.inputMessageAboutCars;
import static step4.view.InputView.inputMessageAboutTry;
import static step4.view.OutputView.*;

public class CarController {

    public static void main(String[] args) {
        MovingStrategy strategy = new RandomMovingStrategy(new RandomGenerator());
        Judge judge = new LongPositionJudge();

        String carNames = inputMessageAboutCars();
        Cars cars = new Cars(produceCars(carNames));

        int numOfTry = inputMessageAboutTry();
        outputMessage();
        for (int i=0; i<numOfTry; i++) {
            cars.moveCars(strategy);
            outputMessageAboutMove(cars.getCars());
        }
        outputMessageAboutWinner(cars.winnerCars(judge));
    }


}
