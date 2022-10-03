package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    public static int COMPARE_NUM = 4;

    public List<Car> createCars(int cars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < cars; i++) {
            carList.add(new Car(0));
        }
        return carList;
    }

    public List<Car> startRace(int raceCnt, List<Car> carList) {
        for (int i = 0; i < raceCnt; i++) {
            for (Car car: carList) {
                if (new RandomUtil().isBiggerThan(COMPARE_NUM)) {
                    car.moveForward();
                }
            }
        }
        return carList;
    }
}
