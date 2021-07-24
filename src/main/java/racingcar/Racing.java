package racingcar;

import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Racing {
    private final InputView view;
    private final Cars cars;
    private int racingTime;

    Racing() {
        view = new InputView();
        cars = new Cars();
    }

    public void start() {
        getInputFromUser();
        ResultView.printResultTitle();
        startRace();
    }

    private void getInputFromUser() {
        getUserInputCountOfCar();
        getUserInputCountOfRacing();
    }


    private void startRace() {
        for (int i = 0; i < racingTime; i++) {
            race();
        }
    }

    public void race() {
        for (Car car : cars.getCars()) {
            car.getPosition().move();
        }
        System.out.println();
    }

    public void getUserInputCountOfCar() {
        cars.addCars(view.inputCountOfCar());
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
