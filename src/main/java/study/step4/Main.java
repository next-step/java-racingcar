package study.step4;

import study.step4.domain.Car;
import study.step4.dto.RacingInput;
import study.step4.move.RandomlyMoveStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingInput input = inputView.enter();

        RacingGame racingGame = new RacingGame(input.getCarNames(), new RandomlyMoveStrategy());


        List<Car> cars = racingGame.getCarList();
        resultView.printInit(cars);

        for (int i = 0; i < input.getTryNum(); i++) {
            racingGame.play();
            cars = racingGame.getCarList();
            resultView.printCars(cars);
        }

        resultView.printWinners(racingGame.getWinnerList());

    }
}
