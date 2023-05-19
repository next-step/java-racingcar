package study.step3;

import study.step3.domain.Car;
import study.step3.dto.RacingInput;
import study.step3.move.RandomlyMoveStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingInput input = inputView.enter();

        RacingGame racingGame = new RacingGame(input.getCarNum(), new RandomlyMoveStrategy());

        resultView.printInit();
        for (int i = 0; i < input.getTryNum(); i++) {
            racingGame.play();
            List<Car> cars = racingGame.getCarList();
            resultView.printCars(cars);
        }

    }
}
