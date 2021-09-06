package race.domain;

import race.view.InputView;
import race.strategy.RandomNumCondition;
import race.view.ResultView;

import java.util.List;

public class CarRace {

    private int gameCount;

    private RandomNumCondition randomNumCondition;

    public CarRace() {
        this.gameCount = setGameCount();
    }

    public static void main(String[] args) {
        CarRace carRace = new CarRace();
        carRace.playGame();
    }

    protected List<String> getCarNames() {
        return InputView.carNamesToList();
    }

    protected int setGameCount() {
        return InputView.gameCountInputOutput();
    }

    protected void playGame() {
        Cars cars = Cars.createCars(getCarNames());
        randomNumCondition = new RandomNumCondition();
        for (int i = 0; i < gameCount; i++) {
            ResultView.printResult(
                    cars.moveCars(randomNumCondition)
            );
        }
        ResultView.printWinner(cars.getWinner());
    }

}
