package study.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        int numberCar = inputView.inputCar();
        List<Car> cars = new ArrayList<Car>();

        for (int i = 0; i < numberCar; ++i) {
            cars.add(new Car());
        }

        int round = inputView.inputRound();

        ResultView resultView = new ResultView(cars, round);
        resultView.loopRound();
    }
}
