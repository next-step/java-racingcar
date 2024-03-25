package RacingGame;

import RacingGame.Domain.CarManager;
import RacingGame.Domain.RandomStrategyNoMatter;
import RacingGame.View.InputView;
import RacingGame.View.OutputView;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String[] carNameInfo = inputView.InputCarsName();
        int trialNum = inputView.InputTrialNumber();

        CarManager carManager = new CarManager(trialNum, carNameInfo, new RandomStrategyNoMatter());
        carManager.moveForwardCars();
        OutputView outputView = new OutputView();
        outputView.PrintResult(carManager.getCarHistory(), carManager.getCarList());
        outputView.PrintWinner(carManager.getWinners());
    }
}
