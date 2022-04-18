package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int carCount = InputView.getCarCount();
        int round = InputView.getGameRound();

        List<Car> cars = CarFactory.createCars(carCount);
        RacingCar racingCar = new RacingCar(cars, round);

        for (int currentRound = 0; currentRound < round; currentRound++) {
            racingCar.playRound();
            ResultView.printCarsPosition(cars);
        }
    }
}
