package study;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private static CarFactory carFactory = null;

    private CarFactory() {

    }

    public static CarFactory getInstance() {
        if (carFactory == null) {
            carFactory = new CarFactory();
        }

        return carFactory;
    }

    public List<RacingCar> createCar(int numberOfCar) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            RacingCar racingCar = new RacingCar();
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }


}
