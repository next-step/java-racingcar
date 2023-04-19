package carracing.domain;

import java.util.ArrayList;
import java.util.List;

public class CarCompany {
    public static List<Car> createCar(String carNames) {
        String[] arrCarNames = splitCarName(carNames);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < arrCarNames.length; i++) {
            //자동차객체 생성
            Car car = new Car(arrCarNames[i]);
            cars.add(car);
        }
        return cars;
    }

    public static String[] splitCarName(String carNames) {
        String[] arrCarNames = carNames.split(",");
        return arrCarNames;
    }
}
