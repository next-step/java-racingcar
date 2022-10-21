package racing.controller;

import racing.domain.Cars;
import racing.domain.Winner;
import racing.msg.SystemMention;
import racing.strategy.RandomMovingStrategy;
import racing.view.ResultView;
import racing.view.UserInput;
import racing.domain.Car;

import java.util.List;

public class RacingGame {

    public void runGame() {
        UserInput userInput = new UserInput();
        List<Car> carList = userInput.inputCarList();
        int cntOfTry = userInput.inputCntOfTry();

        SystemMention.RESULT.printMention();
        Winner winner = new Winner(race(carList, cntOfTry));
        SystemMention.SUFFIX_WINNER.printMention(winner.findWinnersName());
    }

    private List<Car> race(List<Car> carList, int cntOfTry) {
        Cars cars = new Cars(carList);
        ResultView resultView = new ResultView();
        for (int i = 0; i < cntOfTry; i++) {
            cars.moveCars(new RandomMovingStrategy());
            resultView.printRacingResult(cars);
        }
        return cars.getCarList();
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.runGame();
    }
}
