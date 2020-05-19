package step4;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.of();

        String carNames = inputView.getCarName();

        int time = inputView.getTime();

        RacingGame racingGame = RacingGame.create(new RandomMovingStrategy());
        racingGame.readyRacingCars(carNames);

        OutputView.printResult();
        for (int i = 0; i < time; i++) {
            List<RacingCar> racingCars = racingGame.startRacing();
            OutputView.printRacingCars(racingCars);
        }
    }
}
