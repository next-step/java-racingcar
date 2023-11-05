package racinggame.domain;

import racinggame.ui.OutputView;

import java.util.List;

public class Referee {

    public void startRacing(int racingCount, Cars cars) {
        OutputView outputView = new OutputView();

        for (int step = 0; step < racingCount; step++) {
            List<Car> racingResult = cars.racing();
            outputView.printRacing(racingResult);
        }
    }

}
