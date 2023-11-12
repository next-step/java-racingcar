package racing;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public ParticipationCars settingRacingCars(String names) {
        String[] carNames = names.split(",");

        List<Car> cars = new ArrayList<>();
        for (String carname: carNames) {
            cars.add(Car.defaultOf(carname));
        }

        return ParticipationCars.defaultOf(cars);
    }
}
