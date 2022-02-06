package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    public void execute() {
        List<String> carNames = InputView.getName();
        Cars cars = Cars.of(carNames);
        int times = InputView.getTimes();
        Race.playGames(cars.getCars(), times);
        Race.setWinners(cars.getCars());
        OutputView.printWinners(Race.getWinners());
    }
}
