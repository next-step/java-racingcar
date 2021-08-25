package carracing.application;

import static carracing.utils.RandomValueGenerator.generateRandom;

import carracing.domain.Car;
import carracing.domain.CarFactory;
import carracing.domain.Position;
import carracing.domain.RaceResult;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    public RaceResult race(String inputName, int raceCount) {
        String[] names = inputName.split(",");
        List<Car> cars = makeCars(names);

        RaceResult raceResults = new RaceResult(raceCount);

        for (int i = 0; i < raceCount; i++) {
            cars.stream().forEach(car -> car.move(generateRandom()));
            raceResults.saveResult(cars);
        }
        raceResults.saveWinners(findWinners(cars));
        return raceResults;
    }

    private List<Car> makeCars(String[] names) {
        return CarFactory.makeCars(names);
    }

    public List<Car> findWinners(List<Car> cars) {
        Position maxPosition = findMaxPosition(cars);

        return cars.stream()
            .filter(car -> car.position().equals(maxPosition))
            .collect(Collectors.toList());
    }

    private Position findMaxPosition(List<Car> cars) {
        return cars.stream()
            .map(car -> car.position())
            .reduce(Position::calBiggerPosition)
            .get();
    }

}
