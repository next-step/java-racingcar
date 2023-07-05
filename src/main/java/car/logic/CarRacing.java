package car.logic;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    private Cars cars;

    public CarRacing(Cars cars) {
        this.cars = cars;
    }

    public Cars runRaceOnce() {
        this.cars.raceOnce();
        return this.getRaceResult();
    }

    public Cars getRaceResult() {
        return this.cars;
    }

    public List<Car> selectWinner() {
        int maxPos = this.cars.getCars().stream().map(Car::getPosition)
            .max(Comparator.comparing(x -> x)).get();
        return this.cars.getCars().stream().filter(s -> (s.getPosition() == maxPos))
            .collect(Collectors.toList());
    }

}
