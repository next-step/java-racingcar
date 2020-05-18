package step3;

import java.util.ArrayList;
import java.util.List;


public class RacingGame {

    private List<Car> cars = new ArrayList<>();
    private int tryTimes;

    public RacingGame() {
        // set new car
        setupCars(InputView.setCarsCount());
        // set play times.
        this.tryTimes = InputView.setPlayCounts();
    }

    public RacingGame(int carsCount, int tryTimes) {
        // set new car
        setupCars(InputView.inputCheck(carsCount));
        // set play times.
        this.tryTimes = InputView.inputCheck(tryTimes);
    }

    private void setupCars(int carsCnt) {
        for (int i = 0; i < carsCnt; i++) {
            cars.add(new Car(i));
        }
    }

    public void play() {
        ResultView resultView = new ResultView(cars);
        for (int i = 0; i < tryTimes; i++) {
            System.out.println(i + 1 + " th Try.. ");
            for (Car car : cars) {
                car.move();
            }
            resultView.viewResult();
        }
    }


}