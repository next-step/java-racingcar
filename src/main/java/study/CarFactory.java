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

    public List<RacingCar> createCar(List<String> nameList) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String name : nameList) {
            RacingCar racingCar = new RacingCar(name);
            racingCarList.add(racingCar);
        }
        return racingCarList;
    }


}
