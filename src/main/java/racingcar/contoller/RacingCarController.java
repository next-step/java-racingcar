package racingcar.contoller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

import racingcar.domain.Round;
import racingcar.dto.InputManagement;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {

    private RacingGame racingGame;
    private InputManagement inputManagement;

    public RacingCarController(RacingGame racingGame, InputManagement inputManagement) {
        this.racingGame = racingGame;
        this.inputManagement = inputManagement;
    }

    public List<Car> initRacingCars() {
        List<Car> cars = new ArrayList();

        for (String carName : inputManagement.getCarNames()) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public boolean hasNextRound(Round round) {
        return inputManagement.getCountRound() >= round.getRound();
    }

    public void startGame() {
        Cars carGroup = new Cars(initRacingCars());
        racingGame.init(carGroup);

        Round round = new Round();
        while (hasNextRound(round)) {
            racingGame.playRacing();
            racingGame.recordEachRoundPosition(round);
            round.update();
        }

        new ResultView().printResult(racingGame.getFinalResult(), racingGame.getWinners()
                                                                                .getCars());
    }
}
