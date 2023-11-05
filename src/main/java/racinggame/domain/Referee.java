package racinggame.domain;

import racinggame.ui.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public void startRacing(int racingCount, Cars cars) {
        OutputView outputView = new OutputView();

        for (int step = 0; step < racingCount; step++) {
            List<Car> racingResult = cars.racing();
            outputView.printRacing(racingResult);
        }
    }

    public void judgeWinners(Cars cars) {
        OutputView outputView = new OutputView();

        List<Name> winnersName = cars.findWinners().stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
        outputView.printWinners(winnersName);
    }

}
