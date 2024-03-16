package race.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory {

    private static final String COMMA = ",";
    private static final int LENGTH_STANDARD = 5;

    public List<Car> createCars(String names) {
        List<Car> carList = new ArrayList<>();

        for (String name : splitName(names)) {
            lengthException(name);
            carList.add(new Car(name,0));
        }
        return carList;
    }

    public List<String> splitName(String names) {
        return new ArrayList<>(Arrays.asList(names.split(COMMA)));
    }

    public void lengthException(String name) {
        if (!checkNameLength(name)) {
            throw new IllegalArgumentException("자동차 이름 길이는 5 이하여야 합니다.");
        }
    }

    public boolean checkNameLength(String name) {
        return name.length() <= LENGTH_STANDARD;
    }
}
