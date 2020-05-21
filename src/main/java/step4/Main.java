package step4;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.create();
        String carName = inputView.getCarName();
        int time = inputView.getTime();

        RacingGame racingGame = RacingGame.create(new RandomMovingStrategy());
        racingGame.readyRacingCars(carName);

        OutputView.printResult();
        for (int i = 0; i < time; i++) {
            List<RacingCar> racingCars = racingGame.startRacing();
            OutputView.printRacingCars(racingCars);
        }

        OutputView.printRacingGameWinner(racingGame.getWinners());
    }
}
