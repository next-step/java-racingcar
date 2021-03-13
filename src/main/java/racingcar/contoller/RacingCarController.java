package racingcar.contoller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

import racingcar.dto.InputManagement;

import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    private RacingGame racingGame;
    private InputManagement inputManagement;

    public RacingCarController(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public List<Car> initRacingCars() {
        List<Car> cars = new ArrayList();

        for (String carName : inputManagement.getCarNames()) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public void startGame() {
        inputManagement = new InputView().input();

        Cars carGroup = new Cars(initRacingCars());
        racingGame.init(carGroup);

        for (int thisRound = 1; thisRound <= inputManagement.getCountRound(); thisRound++) {
            racingGame.playRacing();
            racingGame.recordEachRoundPosition(thisRound);
        }

        new ResultView().printResult(racingGame.getFinalResult(), racingGame.getWinners()
                                                                                .getCars());
    }
}
