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

    private InputView inputView;
    private RacingGame racingGame;
    private ResultView resultView;
    private InputManagement inputManagement;
    private Cars carGroup;

    public RacingCarController(InputView inputView, RacingGame racingGame, ResultView resultView) {
        this.inputView = inputView;
        this.racingGame = racingGame;
        this.resultView = resultView;
    }

    public List<Car> initRacingCars() {
        List<Car> cars = new ArrayList();

        for (String carName : inputManagement.getCarNames()) {
            cars.add(new Car(carName, 0));
        }

        return cars;
    }

    public void startGame() {
        inputManagement = inputView.input();

        carGroup = new Cars(initRacingCars());
        racingGame.init(carGroup, inputManagement);

        resultView.printResult(racingGame.startRacing(), racingGame.getWinners());
    }
}
