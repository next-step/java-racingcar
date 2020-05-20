package step3;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.of();

        int count = inputView.getCountOfCar();
        int time = inputView.getTime();

        RacingGame racingGame = RacingGame.create(time, new RandomMovingStrategy());
        racingGame.readyRacingCars(count);

        OutputView.printResult();
        for (int i = 0; i < time; i++) {
            List<RacingCar> racingCars = racingGame.startRacing();
            OutputView.printRacingCars(racingCars);
        }
    }
}
