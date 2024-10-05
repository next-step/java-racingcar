package racingCar.step5.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    public static final String CAR_NAME_SEPERATOR = ",";

    private final List<RacingCar> cars;

    public RacingCars(final List<RacingCar> cars){
        this.cars = cars;
    }

    public static RacingCars ofNames(String names) {
        String[] namesArray = splitName(names);
        List<RacingCar> cars = new ArrayList<>();

        for (String carName : namesArray) {
            cars.add(new RacingCar(carName));
        }
        return new RacingCars(cars);
    }

    private static String[] splitName(String names) {
        return names.split(CAR_NAME_SEPERATOR);
    }

    public int countCars() {
        return this.cars.size();
    }
}
