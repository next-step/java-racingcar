package racingcar;

import racingcar.view.ResultView;

import java.util.Random;

public class Racing {
    private int numberOfCar;
    private int times;
    private Car[] carArr;
    private ResultView resultView;

    public Racing(int numberOfCar, int times) {
        this.numberOfCar = numberOfCar;
        this.times = times;
        carArr = new Car[numberOfCar];
        for (int i = 0; i < numberOfCar; i++) {
            carArr[i] = new Car();
        }
        resultView = new ResultView();
    }

    public void start() {
        for (int i = 0; i < times; i++) {
            resultView.showResult(i, carArr);
            run();
        }
    }

    public void run() {
        for (int i = 0; i < numberOfCar; i++) {
            int condition = new Random().nextInt(10);
            if (condition >= 4) {
                carArr[i].move();
            }
        }
    }
}
