package study.step4;

import java.util.ArrayList;
import java.util.List;


public class InputParser {

    public static final String DELIMITER = ",";

    public static List<Car> parse(String string) {
        String[] strings = string.split(DELIMITER);
        List<Car> cars = new ArrayList<>();
        for (String s: strings) {
            cars.add(new Car(s));
        }
        return cars;
    }
}
