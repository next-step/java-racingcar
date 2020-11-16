package step05;

import step03.strategy.RandomMoveStrategy;
import step05.domain.Cars;
import step05.domain.Race;
import step05.view.ResultView;
import step05.view.InputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.readCarNames();
        int numberOfMoves = InputView.readNumberOfMoves();

        final int position = 1;

        Cars cars = Cars.of(carNames, position);

        Race race = Race.of(numberOfMoves, cars);

        List<Cars> raceSnapShot = race.run(RandomMoveStrategy.of());
        ResultView.printRace(raceSnapShot);

        ResultView.printWinners(
                raceSnapShot.get(raceSnapShot.size() - 1)
                        .findTopPositionCars()
        );

    }

}
