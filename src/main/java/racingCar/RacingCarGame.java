package racingCar;

import racingCar.ui.InputView;
import racingCar.ui.ResultView;
import racingCar.utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private int tryTimes;
    private List<Car> raceCar = new ArrayList<>();

    RacingCarGame() {
        InputView inputView = new InputView();
        setRaceCar(inputView.inputCarNames());
        tryTimes = inputView.inputTryTimes();
    }

    RacingCarGame(int tryTimes) {
        this.tryTimes = tryTimes;
    }

    public void play() {
        playRace();
    }

    private void playRace() {
        ResultView resultView = new ResultView();
        for (int i = 0; i < tryTimes; i++) {
            resultView.printCarRace(raceCar);
        }
    }

    public List<Car> setRaceCar(String[] carNames) {
        for (String name : carNames) {
            raceCar.add(new Car(name));
        }

        return raceCar;
    }
}
