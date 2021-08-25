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

        RaceResult raceResult = new RaceResult(raceCount);

        for (int i = 0; i < raceCount; i++) {
            cars.stream().forEach(car -> car.move(generateRandom()));
            raceResult.saveResult(cars);
        }
        raceResult.saveWinners(findWinners(cars));
        return raceResult;
    }

    public List<Car> findWinners(List<Car> cars) {
        Position maxPosition = findMaxPosition(cars);

        return cars.stream()
            .filter(car -> car.position().equals(maxPosition))
            .collect(Collectors.toList());
    }

    private List<Car> makeCars(String[] names) {
        return CarFactory.makeCars(names);
    }

    private Position findMaxPosition(List<Car> cars) {
        return cars.stream()
            .map(car -> car.position())
            .reduce(Position::calBiggerPosition)
            .get();
    }

}
