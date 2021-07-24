package racingcar;

import racingcar.car.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Racing {
    private InputView view;
    private final Cars cars;
    private int racingTime;

    Racing() {
        view = new InputView();
        cars = new Cars();
    }

    public void start() {
        getInputFromUser();
        startRace();
    }

    private void getInputFromUser() {
        getUserInputCountOfCar();
        getUserInputCountOfRacing();
    }


    private void startRace() {
        ResultView.printResultTitle();
        for (int i = 0; i < racingTime; i++) {
            cars.race();
        }
    }

    public void getUserInputCountOfCar() {
        int countOfCar = view.inputCountOfCar();
        cars.addCars(countOfCar);
    }

    public void getUserInputCountOfRacing() {
        racingTime = view.inputCountOfGame();
    }

    public Cars getCars() {
        return this.cars;
    }

    public int getRacingTime() {
        return this.racingTime;
    }
}
