package RacingGame;

import RacingGame.Domain.Car;
import RacingGame.View.InputView;
import RacingGame.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingMain {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<Car>();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        inputView.InputCarNumber(carList);
        int trialNum = inputView.InputTrialNumber();
        System.out.println("Result");
        for (int i = 0; i < trialNum; i++) {
            inputView.MoveCars(carList);
            outputView.PrintResult(carList);
        }
    }
}
