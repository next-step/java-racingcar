package carracing.controller;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.domain.RacingGame;
import carracing.views.InputView;
import carracing.views.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public RacingGameController() {
    }

    public void run(){
            List<Car> carList = inputView.getCarNames().stream()
                    .map(Car::new)
                    .collect(Collectors.toList());
            Cars cars = new Cars(carList);
            int tryCount = inputView.getTryCount();

            RacingGame racingGame = new RacingGame(cars, tryCount);

            while (racingGame.remainTryCount()){
                racingGame.racing();
                resultView.showRacingPosition(racingGame);
            }
            racingGame.getWinners();
            resultView.showWinners(racingGame);
    }
}
