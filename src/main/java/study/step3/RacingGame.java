package study.step3;

import java.util.ArrayList;
import java.util.List;

import static study.step3.ResultView.moveResult;
import static study.step3.ResultView.resultMsg;
import static study.step3.ResultView.endingRoundMsg;

public class RacingGame {

    private static final int DEFAULT_MIN = 0;
    private static final int DEFAULT_MAX = 9;
    private List<Car> carList;

    public void readyGame(int carCount) {
        carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car(0));
        }
    }

    public void startGame(int tryCount) {
        resultMsg();
        for (int i = 0; i < tryCount; i++) {
            for (Car car : carList) {
                if (car.canMove(DEFAULT_MIN, DEFAULT_MAX)) car.move();
                moveResult(car.getPosition());
            }
            endingRoundMsg(i + 1);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
