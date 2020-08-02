package domain;

import view.InputView;

public class RacingGame {

    public void start() {
        int numberOfCars = InputView.inputNumberOfCar();
        int time = InputView.inputTime();

        Cars cars = new Cars(numberOfCars);

        System.out.println("실행 결과");

        for (int i = 0; i < time; i++) {
            cars.race();
        }
    }
}
