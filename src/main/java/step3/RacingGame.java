package step3;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private List<Car> cars = new ArrayList<>();

    private int tryTimes;

    private RacingGame() {
    }

    public RacingGame(int carsCount, int tryTimes) {
        // set new car
        setupCars(InputView.inputCheck(carsCount));
        // set play times.
        this.tryTimes = InputView.inputCheck(tryTimes);
    }

    private void setupCars(int carsCnt) {
        for (int i = 0; i < carsCnt; i++) {

            //        cars.add(new Car(i,                         ));

        }
    }

    public void play() {
        for (int i = 0; i < tryTimes; i++) {
            for (Car car : cars) {
                car.move();
            }
            ResultView.viewResult(cars);
        }
    }


}
