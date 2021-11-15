package racingcar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarService {

    private static final String SPLITTER = ",";

    public static List<Car> makeRacingCarsFromName(String carNames) {

        String[] names = carNames.split(SPLITTER);
        return Arrays.stream(names)
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());

    }

    public List<Car> getWinnerCar(List<Car> cars) {
        Optional<Car> maxLocationValueOfCar = cars.stream().max(Comparator.comparing(Car::getLocation));
        int maxValue = maxLocationValueOfCar.get().getLocation();

        return cars.stream().filter(car -> car.getLocation() == maxValue).collect(Collectors.toList());
    }
}
