package step2;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> carList;

    public RacingGame(int carNum, int trialNum) {
        time = trialNum;
        carList = new ArrayList<>();

        for (int i = 0; i < carNum; i++) {
            carList.add(new Car());
        }
    }

    public List<Car> doGame() {
        for (int i = 0; i < time; i++) {
            moveWholeCar();
        }
        return carList;
    }

    private void moveWholeCar() {
        for (Car car : carList) {
            car.move();
        }
    }


}
