package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {

    private static final String COMMA = ",";
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static List<Car> makeCarList(String names) {
        List<Car> carList = new ArrayList<>();
        for (String name : splitNames(names)) {
            checkCarName(name);
            carList.add(new Car(name, 0));
        }
        return carList;
    }

    private static void checkCarName(String name) {
        if (isNullOrBlank(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNullOrBlank(String name) {
        return name == null || name.isBlank();
    }

    public static List<String> splitNames(String names) {
        return new ArrayList<>(Arrays.asList(names.split(COMMA)));
    }

    public int size() {
        return carList.size();
    }

}
