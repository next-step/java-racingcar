package step4;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static final String NAME_LENGTH_ERROR = "이름은 5글자를 넘을 수 없습니다.";
    public static final int MAX_NAME_LENGTH = 5;
    public static final String NAME_SEPARATOR = ",";

    public static List<Car> produceCar(String inputName) {
        List<Car> carList = new ArrayList<>();
        for (String name : inputName.split(NAME_SEPARATOR)) {
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
