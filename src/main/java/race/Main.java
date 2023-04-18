package race;

import race.view.InputView;
import race.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int laps = InputView.getLaps();
        final int MIN_MOVE_CONDITION = 4;
        final int MAX_MOVE_BOUND = 10;
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(MIN_MOVE_CONDITION, MAX_MOVE_BOUND);
        Cars cars = new Cars(List.of(), randomMoveStrategy);
        Race race = new Race(cars);

        ResultView.showResultComment();
        for (int i = 0; i < laps; i++) {
            ResultView.showCars(race.startLap());
        }
    }
}
