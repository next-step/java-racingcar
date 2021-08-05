package carracing.application;

import static carracing.utils.RandomValueGenerator.generateRandom;

import carracing.domain.Car;
import carracing.domain.CarFactory;
import carracing.domain.RaceResult;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    public List<RaceResult> race(String inputName, int raceCount) {
        String[] names = inputName.split(",");
        List<Car> cars = makeCars(names);
        List<RaceResult> results = new ArrayList<>();

        for (int i = 0; i < raceCount; i++) {
            RaceResult result = new RaceResult();
            cars.stream().forEach(car -> car.move(generateRandom()));
            result.saveResult(cars);
            results.add(result);
        }
        return results;
    }

    public List<Car> findWinners(List<Car> cars) {
        int maxLocation = cars.stream()
            .max(Comparator.comparingInt(o -> o.location()))
            .get().location();
        List<Car> winners = cars.stream()
            .filter(car -> car.location() == maxLocation)
            .collect(Collectors.toList());
        return winners;
    }

    public List<Car> makeCars(String[] names) {
        return CarFactory.makeCars(names);
    }

}
