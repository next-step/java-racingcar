package step5.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static final String NAME_LENGTH_ERROR = "이름은 5글자를 넘을 수 없습니다.";
    public static final int MAX_NAME_LENGTH = 5;

    public static List<Car> produceCar(String[] inputNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : inputNames) {
            Car car = new Car(checkNameLengths(name));
            carList.add(car);
        }
        return carList;
    }

    public static String checkNameLengths(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException(NAME_LENGTH_ERROR);
        }
        return name;
    }
}
