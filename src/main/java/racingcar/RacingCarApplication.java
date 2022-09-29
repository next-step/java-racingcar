package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        String[] carNames = InputView.carNamesScan();
        int round = InputView.roundScan();
        List<Car> cars = null;

        Race race = new Race(carNames);
        ResultView.printStartMessage();
        for (int i = 0; i < round; i++) {
            cars = race.playRace();
            ResultView.printRace(cars);
        }
        ResultView.printResult(race.findWinners(cars));
    }
}
