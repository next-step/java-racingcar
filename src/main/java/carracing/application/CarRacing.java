package carracing.application;

import static carracing.utils.RandomValueGenerator.generateRandom;

import carracing.domain.Car;
import carracing.domain.CarFactory;
import java.util.List;

public class CarRacing {

    public void race(int carCount, int raceCount) {
        List<Car> cars = makeCars(carCount);

        for (int i=0; i<raceCount; i++) {
            cars.stream().forEach(car -> car.move(generateRandom()));
        }
    }

    public List<Car> makeCars(int count) {
        return CarFactory.makeCars(count);
    }
}
