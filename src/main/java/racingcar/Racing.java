package racingcar;

import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.util.Util;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Racing {
    InputView view = new InputView();
    private final Cars cars;
    private int racingTime;

    Racing() {
        cars = new Cars();
    }

    public void start() {
        prepareRacing();
        startRacing();
    }

    private void prepareRacing() {
        userInputNumberOfCar();
        userInputNumberOfRacing();
    }


    private void startRacing() {
        ResultView.printResultTitle();
        for (int i = 0; i < racingTime; i++) {
            racing(cars);
        }
    }

    private void racing(Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(Util.generateRandom());
            ResultView.printCarPositionStatus(car.getPosition());
        }
        ResultView.printFinishedOneRacing();
    }

    public void userInputNumberOfCar() {
        int numberOfCar = view.inputNumberOfCar();
        cars.setCars(numberOfCar);
    }

    public void userInputNumberOfRacing() {
        racingTime = view.inputNumberOfGame();
    }

    public Cars getCars(){
        return this.cars;
    }

    public int getRacingTime(){
        return this.racingTime;
    }
}
