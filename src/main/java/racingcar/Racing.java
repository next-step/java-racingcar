package racingcar;

import racingcar.car.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Racing {
    private final Cars cars;
    private int racingTime;

    Racing() {
        cars = new Cars();
    }

    public void start() {
        getInputFromUser();
        ResultView.printResultTitle();
        startRace();
    }

    private void getInputFromUser() {
        cars.setUserInputCountOfCar();
        setUserInputCountOfRacing();
    }

    private void startRace() {
        for (int i = 0; i < racingTime; i++) {
            cars.moveCars();
        }
    }

    public void setUserInputCountOfRacing() {
        racingTime = InputView.inputCountOfGame();
    }

    public int getRacingTime() {
        return this.racingTime;
    }
}
