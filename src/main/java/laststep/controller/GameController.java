package laststep.controller;

import laststep.domain.Cars;
import laststep.service.CarFactory;
import laststep.service.ExceptionTemplate;
import laststep.ui.InputView;
import laststep.ui.OutputView;

public class GameController {
    private final CarFactory carFactory = new CarFactory();

    public void start() {
        Cars cars = makeCars();
        OutputView.playTimes();
        ExceptionTemplate exception = InputView::howManyPlay;
        int playTimes = (int) exception.confirm();
        playRace(playTimes, cars);
    }

    private Cars makeCars() {
        OutputView.start();
        ExceptionTemplate exception = () -> carFactory.makeCars(InputView.participants());
        return (Cars) exception.confirm();
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
