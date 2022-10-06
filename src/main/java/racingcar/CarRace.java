package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    public static int COMPARE_NUM = 4;
    public List<Car> carList = new ArrayList<>();

    public List<Car> race(int cars, int raceCnt) {
        for (int i = 0; i < cars; i++) {
            carList.add(new Car());
        }
        return raceResult(raceCnt, carList);
    }

    private List<Car> raceResult(int raceCnt, List<Car> carList) {
        for (int i = 0; i < raceCnt; i++) {
            for (Car car: carList) {
                int randomNum = new RandomUtil().generateRandomNum();
                if (isBiggerThanRandomNumber(randomNum)) {
                    car.moveForward();
                }
            }
        }
        return carList;
    }

    private boolean isBiggerThanRandomNumber(int randomNumber) {
        return randomNumber >= COMPARE_NUM;
    }
}
