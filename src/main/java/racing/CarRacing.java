package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CarRacing {

    private final List<Car> cars;
    private final int racingCount;

    private final RandomFactory randomFactory;

    public CarRacing(int carCounts, int racingCount, RandomFactory randomFactory) {
        this.cars = initCars(carCounts);
        this.racingCount = racingCount;
        this.randomFactory = randomFactory;
    }

    private List<Car> initCars(int carCounts) {
        return IntStream.range(0, carCounts).mapToObj(x -> new Car()).collect(Collectors.toUnmodifiableList());
    }

    public int getRacingCount(){
        return racingCount;
    }

    public List<String> step() {
        return cars.stream()
                .map(car -> car.run(randomFactory.getNextInt()))
                .collect(Collectors.toList());
    }
}
