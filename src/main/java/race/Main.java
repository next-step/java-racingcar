package race;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputView inputView = InputView.of();

        int count = inputView.getCountOfCar();
        int time = inputView.getTime();
        RacingGame racingGame = RacingGame.of(count, time);
        racingGame.readyRacingCars(count);

        OutputView.printResult();
        for (int i = 0; i < racingGame.getTime(); i++) {
            List<RacingCar> racingCars = racingGame.start();
            OutputView.printRacing(racingCars);
        }
    }
}
