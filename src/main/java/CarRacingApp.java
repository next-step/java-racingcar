import racingCar.domain.Cars;
import racingCar.domain.RandomNumber;
import racingCar.view.InputView;
import racingCar.view.ResultView;

import java.util.List;

public class CarRacingApp {
    public static void main(String[] args) {
        int[] inputValues = InputView.input();
        int carNum = inputValues[0];
        int tryNum = inputValues[1];

        Cars cars = new Cars(carNum);

        List<String> status = cars.repeatMove(tryNum, new RandomNumber());

        ResultView.printCarStatus(status);
    }
}
