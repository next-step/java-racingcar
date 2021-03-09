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

    private InputView inputView = new InputView();
    private Cars carGroup;
    private RacingGame racingGame = new RacingGame();
    private ResultView resultView = new ResultView();

    public List<Car> initRacingCars() {
        List<Car> cars = new ArrayList();

        for (String carName : InputManagement.getCarNames()) {
            cars.add(new Car(carName, 0));
        }

        return cars;
    }

    public void startGame() {
        inputView.input();

        carGroup = new Cars(initRacingCars());
        racingGame.startRacing(carGroup);

        resultView.printResult(racingGame.getFinalResult());
    }
}
