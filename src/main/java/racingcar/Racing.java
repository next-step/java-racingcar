package racingcar;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    private int numberOfCar;
    private int times;
    private List<Car> carList;
    private ResultView resultView;

    public Racing(int numberOfCar, int times) {
        this.numberOfCar = numberOfCar;
        this.times = times;
        carList = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            carList.add(new Car());
        }
        resultView = new ResultView();
    }

    public void start() {
        for (int i = 0; i < times; i++) {
            resultView.showResult(i, carList);
            run();
        }
    }

    public void run() {
        for (int i = 0; i < numberOfCar; i++) {
            moveCar(i);
        }
    }

    private void moveCar(int i) {
        int condition = new Random().nextInt(10);
        if (condition >= 4) {
            carList.get(i).move();
        }
    }


}
