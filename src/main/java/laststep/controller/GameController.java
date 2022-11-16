package laststep.controller;

import java.util.List;
import laststep.service.CarFactory;
import laststep.domain.Cars;
import laststep.ui.InputView;
import laststep.ui.OutputView;

public class GameController {
    private final CarFactory carFactory = new CarFactory();

    public void start() {
        List<String> participants = InputView.participants();
        Cars cars = carFactory.makeCars(participants);
        int playTimes = InputView.howManyPlay();
        playRace(playTimes, cars);
    }

    private void playRace(int playTimes, Cars cars) {
        OutputView.raceResult();
        for (int i = 0; i < playTimes; i++) {
            cars.race();
            OutputView.match(cars);
        }
        OutputView.winner(cars);
    }
}
