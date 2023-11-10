package study.step4.view;

import java.util.ArrayList;
import java.util.List;

import study.step4.domain.Car;


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
