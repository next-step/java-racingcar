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
        resultOfRace();
    }

    private void getInputFromUser() {
        cars.setCarsByUserInputNames();
        setUserInputCountOfRace();
    }

    private void startRace() {
        for (int i = 0; i < racingTime; i++) {
            cars.moveCars();
        }
    }

    private void resultOfRace() {
        cars.produceResult();
    }

    private void setUserInputCountOfRace() {
        racingTime = Integer.parseInt(InputView.inputCountOfGame());
    }

}
