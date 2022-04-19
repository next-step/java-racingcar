package racingcar;

import racingcar.pattern.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {

        int carCount = InputView.getCarCount();
        int round = InputView.getGameRound();

        Cars cars = new Cars(Cars.createCars(carCount));
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RacingCar racingCar = new RacingCar(cars, round, randomNumberGenerator);

        for (int currentRound = 0; currentRound < round; currentRound++) {
            racingCar.playRound();
            ResultView.printCarsPosition(cars);
        }
    }
}
