package domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    public static List<RacingCar> racingCarList = new ArrayList<>();

    public static List<RacingCar> createCar(int inputNum) {
        for (int i = 0; i < inputNum; i++) {
            RacingCar car = new RacingCar();
            racingCarList.add(car);
        }
        return racingCarList;
    }
}
