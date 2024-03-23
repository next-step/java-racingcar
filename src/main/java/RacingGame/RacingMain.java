package RacingGame;

import RacingGame.Domain.Car;
import RacingGame.Domain.CarManager;
import RacingGame.View.InputView;
import RacingGame.View.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingMain {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<Car>();
        InputView inputView = new InputView();

        int carNum = inputView.InputCarNumber();
        int trialNum = inputView.InputTrialNumber();

        CarManager carManger = new CarManager(carNum, trialNum);
        carManger.MoveForwardCars(trialNum);
        OutputView outputView = new OutputView();
        outputView.PrintResult(carManger.GetCarHistory(), carNum, trialNum);
    }
}
