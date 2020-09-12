package step4.utils;

import step4.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static final String CAR_NAME_DELIMETER = ",";

    public static List<Car> create(String names) {
        String[] nameList = names.split(CAR_NAME_DELIMETER);

        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < nameList.length; i++) {
            Car car = new Car();
            ValidationUtils.validationName(nameList[i]);
            car.setName(nameList[i]);
            car.setPosition(0);
            cars.add(car);
        }
        return cars;
    }

}
