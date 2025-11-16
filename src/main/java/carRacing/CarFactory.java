package carRacing;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static final String SPLIT_RULE = ",";

    public static List<RacingCar> from(String name) {
        return setRacingCarsByNames(split(name));
    }

    private static List<RacingCar> setRacingCarsByNames(String[] names) {
        List<RacingCar> cars = new ArrayList<>();
        for (String value : names) {
            cars.add(new RacingCar(value));
        }
        return cars;
    }

    private static String[] split(String name) {
        return name.split(SPLIT_RULE);
    }
}
