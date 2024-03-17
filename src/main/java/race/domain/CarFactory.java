package race.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory {

    private static final String COMMA = ",";

    public static List<Car> createCars(String names) {
        List<Car> carList = new ArrayList<>();

        for (String name : splitName(names)) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public static List<String> splitName(String names) {
        return new ArrayList<>(Arrays.asList(names.split(COMMA)));
    }
}
