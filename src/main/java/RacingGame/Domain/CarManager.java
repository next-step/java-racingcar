package RacingGame.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarManager {
    List<Car> carList;
    int[][] carHistory;

    public CarManager(int carNum, int trialNum) {
        carList = new ArrayList<>();
        carHistory = new int[carNum][trialNum];
        for (int i = 0; i < carNum; i++) {
            Car car = new Car();
            carList.add(car);
        }
    }

    public void MoveForwardCars(int trialNum) {
        for (int i = 0; i < trialNum; i++) {
            Random random = new Random();
            int val;
            for (int j = 0; j < carList.size(); j++) {
                val = random.nextInt(10);
                carList.get(j).MoveForward(val);
                carHistory[j][i] = carList.get(j).GetMoveInfo();
            }
        }
    }

    public int[][] GetCarHistory() {
        return carHistory;
    }
}
