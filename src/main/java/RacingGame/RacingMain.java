package RacingGame;

import RacingGame.Domain.Car;
import RacingGame.Domain.CarManager;
import RacingGame.Domain.RandomStrategyNoMatter;
import RacingGame.View.InputView;
import RacingGame.View.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingMain {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<Car>();
        String[] carNameInfo;
        InputView inputView = new InputView();

        carNameInfo = inputView.InputCarsName();
        int trialNum = inputView.InputTrialNumber();

        CarManager carManager = new CarManager(trialNum, carNameInfo);
        carManager.SetStrategy(new RandomStrategyNoMatter());
        carManager.MoveForwardCars(trialNum);
        OutputView outputView = new OutputView();
        outputView.PrintResult(carManager.GetCarHistory(), carManager.GetCarList());
        outputView.PrintWinner(carManager.GetWinners());
    }
}
