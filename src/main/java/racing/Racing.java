package racing;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Racing {

    public Racing() {
    }

    public List<Car> generateNamedCar(RaceInfo raceInfo) {
        String[] names = raceInfo.nameData();
        return Arrays.stream(names).map(Car::new).collect(Collectors.toList());
    }

    public void goRacing(List<Car> cars, RaceInfo raceInfo) {
        int trials = raceInfo.trialData();
        new Car().race(cars, trials);
    }

    public List<String> winner(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::carDistance)
                .max().orElseThrow(NoSuchElementException::new);

        return cars.stream()
                .filter(car -> car.equalDistance(maxDistance))
                .map(Car::carName)
                .collect(Collectors.toList());
    }
}
