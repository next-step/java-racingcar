package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingSystem {

    private int carCount;
    private int racingCount;
    private List<Car> cars = new ArrayList<>();

    public void init() {
        InputView inputView = new InputView(new Scanner(System.in));
        this.carCount = inputView.askCarCount();
        this.racingCount = inputView.askRacingCount();
        makeCars();
        racingStart();
    }

    private void racingStart() {
        for (int i = 0; i < racingCount; i++) {
            racing();
        }
    }

    private void racing() {
        for (Car car : cars) {
            car.move(new Random().nextInt(10));
        }
        ResultView.result(cars);
    }

    private void makeCars() {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public static void main(String[] args) {
        new RacingSystem().init();
    }
}
