package race;

import race.view.InputView;
import race.view.ResultView;

public class Main {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int laps = InputView.getLaps();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        Cars cars = CarsFactory.makeCars(carNames, randomMoveStrategy);
        Race race = new Race(cars);

        ResultView.showResultComment();
        for (int i = 0; i < laps; i++) {
            ResultView.showCarViewList(race.startLap());
        }
        ResultView.showWinners(race.getWinners());
    }
}
