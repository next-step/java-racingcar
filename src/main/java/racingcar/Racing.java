package racingcar;

import racingcar.view.ResultView;

import java.util.Random;

public class Racing {
    int carNum;
    int times;
    Car[] carArr;
    ResultView resultView;

    public Racing(int carNum, int times) {
        this.carNum = carNum;
        this.times = times;
        carArr = new Car[carNum];
        for (int i = 0; i < carNum; i++) {
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
        for (int i = 0; i < carNum; i++) {
            int condition = new Random().nextInt(10);
            if (condition >= 4) {
                carArr[i].move();
            }
        }
    }
}
