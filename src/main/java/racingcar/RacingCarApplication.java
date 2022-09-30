package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {
        String[] carNames = InputView.carNamesScan();
        int round = InputView.roundScan();
        Cars cars = new Cars(carNames);

        Race race = new Race(cars.getCars());

        ResultView.printStartMessage();

        for (int i = 0; i < round; i++) {
            ResultView.printRace(race.playRace());
        }
        ResultView.printResult(race.findWinners());
    }

}
