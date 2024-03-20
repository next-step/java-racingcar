package RacingGame;

import RacingGame.Domain.Car;
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

        for (int i = 0; i < carNum; i++) {
            Car car = new Car();
            carList.add(car);
        }

        Random random = new Random();
        OutputView outputView = new OutputView();
        int val;
        for (int i = 0; i < trialNum; i++) {
            for (int j = 0; j < carNum; j++) {
                val = random.nextInt(10);
                carList.get(j).MoveForward(val);
            }
            outputView.PrintResult(carList);
        }
    }
}
