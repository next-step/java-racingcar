package carracing.domain;

import java.util.ArrayList;
import java.util.List;

import static carracing.utile.StringUtile.split;

public class CarCompany {
    public static List<Car> createCar(String carNames) {
        String[] arrCarNames = split(carNames);
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < arrCarNames.length; i++) {
            //자동차객체 생성
            Car car = new Car(arrCarNames[i]);
            cars.add(car);
        }
        return cars;
    }

}
