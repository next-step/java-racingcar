package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        String[] carNames = InputView.carNamesScan();
        int round = InputView.roundScan();
        List<Car> cars = null;

        Race.ready(carNames);

        ResultView.printStartMessage();

        for (int i = 0; i < round; i++) {
            cars = Race.playRace();
            ResultView.printRace(Race.playRace());
        }
        ResultView.printResult(Race.findWinners(cars));
    }
}
