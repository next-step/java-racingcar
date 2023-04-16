package race;

import race.view.InputView;
import race.view.ResultView;

public class Main {
    public static void main(String[] args) {
        int numOfCars = InputView.getCarNums();
        int laps = InputView.getLaps();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(4, 10);
        Cars cars = new Cars(numOfCars, randomMoveStrategy);
        Race race = new Race(cars);

        ResultView.showResultComment();
        for (int i = 0; i < laps; i++) {
            ResultView.showPositions(race.startLap());
        }
    }
}
